package com.ratna.spring.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.spring.mongodb.model.Book;
import com.ratna.spring.mongodb.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@GetMapping("/booksList")
	public List<Book> retrieveBooks() {
		return bookService.retrieveBooks();
	}

	@GetMapping("/book/id/{id}")
	public Optional<Book> getSelectedBook(@PathVariable Integer id) {
		return bookService.getSelectedBook(id);
	}

	@DeleteMapping("/book/id/{id}")
	public String deleteSelectedBook(@PathVariable Integer id) {
		return bookService.deleteSelectedBook(id);
	}

	@GetMapping("/sortbook/byfield/{sort}/withrecords/{size}")
	public List<Book> sortBooks(@PathVariable String sort, @PathVariable Integer size) {
		return bookService.sortBooks(sort, size);
	}

	@GetMapping("/example/id/{id}")
	public List<Book> getBookByExample(@PathVariable Integer id) {
		return bookService.getBookByExample(id);
	}

	@GetMapping("/book/by/{bookName}/author/{authorName}")
	public Book findBookByAuthorAndBookName(@PathVariable String bookName, @PathVariable String authorName) {
		return bookService.findBookByAuthorAndBookName(bookName, authorName);
	}

	@GetMapping("/author/{authorName}")
	public List<Book> findBookByAuthorName(@PathVariable String authorName) {
		return bookService.findBookByAuthorName(authorName);
	}

	@GetMapping("/book/by/{bookName}")
	public List<Book> findBookByBookName(@PathVariable String bookName) {
		return bookService.findBookByBookName(bookName);
	}

	@GetMapping("/book/by/query/{bookName}")
	public Book byQuery(@PathVariable String bookName) {
		return bookService.byQuery(bookName);
	}
	
	@GetMapping("/book/byquery/{bookName}/author/{authorName}")
	public List<Book> findBookByAuthorAndBookNameQuery(@PathVariable String bookName, @PathVariable String authorName) {
		return bookService.findBookByBookNameAndAuthorName(bookName, authorName);
	}
	@PostMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateAuthorName(book);
	}
}