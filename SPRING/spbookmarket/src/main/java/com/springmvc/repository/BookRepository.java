package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;

public interface BookRepository
{
	List<Book> getAllBookList(); // 전체 책 조회
	List<Book> getBookListByCategory(String category); // 카테고리로 조회
	Set<Book> getBookListByFilter(Map<String, List<String>> filter); // 책 필터링
	Book getBookById(String bookId); // 도서 아이디로 책 조회
}
