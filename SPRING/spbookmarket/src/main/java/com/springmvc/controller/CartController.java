package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springmvc.domain.Book;
import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestCartId(HttpServletRequest request) {
        System.out.println("[GET] /cart - 메서드 진입");

        String sessionId = request.getSession(true).getId();
        System.out.println("세션 ID: " + sessionId);

        String redirectUrl = "redirect:/cart/" + sessionId;
        System.out.println("리다이렉트 URL: " + redirectUrl);

        return redirectUrl;
    }

    @PostMapping
    public @ResponseBody Cart create(@RequestBody Cart cart) {
        System.out.println("[POST] /cart - 메서드 진입");
        System.out.println("요청으로 받은 Cart 객체: " + cart);

        Cart createdCart = cartService.create(cart);
        System.out.println("생성된 Cart 객체: " + createdCart);

        return createdCart;
    }

    @GetMapping("/{cartId}")
    public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
        System.out.println("[GET] /cart/{cartId} - 메서드 진입");
        System.out.println("요청된 Cart ID: " + cartId);

        Cart cart = cartService.read(cartId);

        if (cart == null) {
            System.out.println("Cart 객체가 존재하지 않음 (null)");
        } else {
            System.out.println("조회된 Cart 객체: " + cart);
        }

        model.addAttribute("cart", cart);
        System.out.println("Model에 'cart' 추가 완료");

        return "cart";
    }

    @PutMapping("/{cartId}")
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        System.out.println("[PUT] /cart/{cartId} - 메서드 진입");
        System.out.println("요청된 Cart ID: " + cartId);

        Cart cart = cartService.read(cartId);

        if (cart == null) {
            System.out.println("Cart 객체가 존재하지 않음 (null)");
        } else {
            System.out.println("조회된 Cart 객체: " + cart);
        }

        return cart;
    }
    
    @PutMapping("/add/{bookId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request)
    {
    	String sessionId = request.getSession(true).getId();
    	Cart cart = cartService.read(sessionId);
    	
    	if(cart == null)
    	{
    		cart = cartService.create(new Cart(sessionId));
    	}
    	
    	Book book = bookService.getBookById(bookId);
    	
    	if(book == null)
    	{
    		throw new IllegalArgumentException(new BookIdException(bookId));
    	}
    	
    	cart.addCartItem(new CartItem(book));
    	cartService.update(sessionId, cart);
    }
    
    @PutMapping("/remove/{bookId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeCartByItem(@PathVariable String bookId, HttpServletRequest request)
    {
    	System.out.println("remove 입장");
    	String sessionId = request.getSession(true).getId();
    	Cart cart = cartService.read(sessionId);
    	
    	System.out.println("cart: " + cart);
    	if(cart == null)
    	{
    		System.out.println("cart 없음");
    		cart = cartService.create(new Cart(sessionId));
    	}
    	
    	Book book = bookService.getBookById(bookId);
    	
    	if(book == null)
    	{
    		throw new IllegalArgumentException(new BookIdException(bookId));
    	}
    	
    	System.out.println("book: " + book.toString());
    	
    	cart.removeCartItem(new CartItem(book));
    	cartService.update(sessionId, cart);
    }
}
