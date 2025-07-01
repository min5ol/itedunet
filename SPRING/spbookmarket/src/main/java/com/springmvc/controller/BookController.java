package com.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;
import com.springmvc.exception.CategoryException;
import com.springmvc.service.BookService;
import com.springmvc.validator.BookValidator;
import com.springmvc.validator.UnitsInStockValidator;

@Controller
@RequestMapping("/books")
public class BookController {

    public static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private UnitsInStockValidator unitsInStockValidator;

    @Autowired
    private BookValidator bookValidator;

    @GetMapping
    public String requestBookList(Model model) {
        logger.info("📚 [GET] /books");
        List<Book> list = bookService.getAllBookList();
        model.addAttribute("bookList", list);
        return "books";
    }

    @GetMapping("/all")
    public ModelAndView requestAllBooks() {
        ModelAndView mav = new ModelAndView();
        List<Book> list = bookService.getAllBookList();
        mav.addObject("bookList", list);
        mav.setViewName("books");
        return mav;
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
        logger.info("📚 [GET] /books/{}", bookCategory);
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);

        if (booksByCategory == null || booksByCategory.isEmpty()) {
            throw new CategoryException();
        }

        model.addAttribute("bookList", booksByCategory);
        return "books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model) {
        logger.info("📚 [GET] /books/filter with filter: {}", bookFilter);
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books";
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {
        logger.info("📚 [GET] /books/book?id={}", bookId);
        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "book";
    }

    @GetMapping("/add")
    public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
        logger.info("📚 [GET] /books/add");
        return "addBook";
    }

    @PostMapping("/add")
    public String submitAddNewBook(@Valid @ModelAttribute("NewBook") Book book,
                                   BindingResult result,
                                   HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addBook";
        }

        MultipartFile bookImage = book.getBookImage();

        String uploadDir = request.getServletContext().getRealPath("/resources/images");
        System.out.println("===== [Add] 업로드 경로: " + uploadDir);

        if (bookImage != null) {
            System.out.println("===== [Add] 원본 파일명: " + bookImage.getOriginalFilename());
            System.out.println("===== [Add] isEmpty: " + bookImage.isEmpty());
        }

        if (bookImage != null && !bookImage.isEmpty()) {
            String saveName = bookImage.getOriginalFilename();
            File saveFile = new File(uploadDir, saveName);

            try {
                if (!saveFile.getParentFile().exists()) {
                    saveFile.getParentFile().mkdirs();
                }

                bookImage.transferTo(saveFile);
                System.out.println("===== [Add] 저장 완료: " + saveFile.getAbsolutePath());
                book.setFileName(saveName);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("도서 이미지 업로드 실패", e);
            }
        }

        bookService.setNewBook(book);
        return "redirect:/books";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("addTitle", "신규 도서 등록");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(bookValidator);
        binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category",
                "unitsInStock", "totalPages", "releaseDate", "condition", "bookImage");
    }

    @ExceptionHandler(value = {BookIdException.class})
    public ModelAndView handleError(HttpServletRequest req, BookIdException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidBookId", exception.getBookId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("errorBook");
        return mav;
    }

    @GetMapping("/update")
    public String getUpdateBookForm(@ModelAttribute("updateBook") Book book,
                                    @RequestParam("id") String bookId,
                                    Model model) {
        logger.info("📚 [GET] /books/update?id={}", bookId);
        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "updateForm";
    }

    @PostMapping("/update")
    public String submitUpdateBookForm(@ModelAttribute("updateBook") Book book,
                                       HttpServletRequest request) {
        MultipartFile bookImage = book.getBookImage();

        String uploadDir = request.getServletContext().getRealPath("/resources/images");
        System.out.println("===== [Update] 업로드 경로: " + uploadDir);

        if (bookImage != null) {
            System.out.println("===== [Update] 원본 파일명: " + bookImage.getOriginalFilename());
            System.out.println("===== [Update] isEmpty: " + bookImage.isEmpty());
        }

        if (bookImage != null && !bookImage.isEmpty()) {
            try {
                String fname = bookImage.getOriginalFilename();
                File saveFile = new File(uploadDir, fname);

                if (!saveFile.getParentFile().exists()) {
                    saveFile.getParentFile().mkdirs();
                }

                bookImage.transferTo(saveFile);
                System.out.println("===== [Update] 저장 완료: " + saveFile.getAbsolutePath());

                book.setFileName(fname);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Book Image saving failed", e);
            }
        }

        bookService.setUpdateBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete")
    public String getDeleteBookForm(Model model, @RequestParam("id") String bookId) {
        logger.info("📚 [DELETE] /books/delete?id={}", bookId);
        bookService.setDeleteBook(bookId);
        return "redirect:/books";
    }

}
