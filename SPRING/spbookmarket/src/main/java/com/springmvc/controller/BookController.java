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
import com.springmvc.validator.UnitsInStockValidator;

@Controller
@RequestMapping("/books")
public class BookController
{
	public static Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UnitsInStockValidator unitsInStockValidator;
	
	@GetMapping
	public String requestBookList(Model model)
	{
		logger.info("requestBookList 메서드 : get");
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllBooks()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		modelAndView.addObject("bookList",list);
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model)
	{
		System.out.println("controller : requestBooksByCategory");
		System.out.println(bookCategory);
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		
		if(booksByCategory == null || booksByCategory.isEmpty())
		{
			throw new CategoryException();
		}
		
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model)
	{
		System.out.println("controller : requestBooksByFilter");
		
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		
		return "books";
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model)
	{
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		
		return "book";
	}
	
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book)
	{
		logger.info("📚 GET /books/add 호출됨");
		return "addBook";
	}
	
	@PostMapping("/add")
	public String submitAddNewBook(@Valid @ModelAttribute("NewBook") Book book, HttpServletRequest request, BindingResult result) {
	    
		if(result.hasErrors())
	    {
	    	return "addBook";
	    }
		
		MultipartFile bookImage = book.getBookImage();

	    String uploadDir = request.getServletContext().getRealPath("/resources/images");

	    String saveName = bookImage.getOriginalFilename();
	    File saveFile = new File(uploadDir, saveName);
	    
	    System.out.println("저장경로: " + uploadDir);
	    System.out.println("파일명: " + saveName);
	    System.out.println("MultipartFile isEmpty: " + bookImage.isEmpty());


	    if (bookImage != null && !bookImage.isEmpty()) 
	    {
	        try {
	            if (!saveFile.getParentFile().exists())
	            {
	                saveFile.getParentFile().mkdirs();
	            }

	            bookImage.transferTo(saveFile);
	        } catch (Exception e) 
	        {
	            throw new RuntimeException("도서 이미지 업로드가 실패하였습니다", e);
	        }
	    }

	    book.setImageFilename(saveName);

	    bookService.setNewBook(book);
	    return "redirect:/books";
	}
	
	@ModelAttribute
	public void addAttributes(Model model)
	{
		model.addAttribute("addTitle", "신규 도서 등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.setValidator(unitsInStockValidator);
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category", "unitInStock", "totalPages", "releaseDate", "condition", "bookImage");
	}
	
	@ExceptionHandler(value= {BookIdException.class})
	public ModelAndView handleError(HttpServletRequest req, BookIdException exception)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidBookId", exception.getBookId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("errorBook");
		
		return mav;
	}
}