package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;
import com.springmvc.repository.CartRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	public List<Book> getAllBookList()
	{
		return bookRepository.getAllBookList();
	}
	
	public List<Book> getBookListByCategory(String category)
	{
		System.out.println("service : getBookListByCategory");
		List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
		return booksByCategory;
	}
	
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter)
	{
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		
		return booksByFilter;
	}
	
	public Book getBookById(String bookId)
	{
		Book bookById = bookRepository.getBookById(bookId);
		return bookById;
	}
	
	public void setNewBook(Book book)
	{
		bookRepository.setNewBook(book);
	}
	
	public void setUpdateBook(Book book)
	{
		bookRepository.setUpdateBook(book);
	}
	
	public void setDeleteBook(String bookId)
	{
		bookRepository.setDeleteBook(bookId);
	}
}
