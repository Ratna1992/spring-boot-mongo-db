package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.ratna.spring.mongodb.model.Book;

public interface BookServiceInterface {

	public String saveBook(@RequestBody Book book);

	public List<Book> retrieveBooks();

	public Optional<Book> getSelectedBook(Integer id);

	public String deleteSelectedBook(Integer id);

	public List<Book> sortBooks(String bookName, Integer size);

	public List<Book> getBookByExample(Integer id);

	public Book findBookByAuthorAndBookName(String bookName, String authorName);

	public List<Book> findBookByAuthorName(String authorName);

	public List<Book> findBookByBookName(String bookName);

	public Book byQuery(String bookName);

	public List<Book> findBookByBookNameAndAuthorName(String bookName, String authorName);

	public Book updateAuthorName(Book book);
}
