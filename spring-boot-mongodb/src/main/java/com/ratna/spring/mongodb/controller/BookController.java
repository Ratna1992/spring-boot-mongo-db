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

import com.ratna.spring.mongodb.exceptions.NoBookDataException;
import com.ratna.spring.mongodb.model.Book;
import com.ratna.spring.mongodb.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Book book) {
		try {
			return bookService.saveBook(book);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("Unable to insert book into database");
		}
	}

	@GetMapping("/booksList")
	public List<Book> retrieveBooks() {
		try {
			return bookService.retrieveBooks();
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No books available");
		}
	}

	@GetMapping("/book/id/{id}")
	public Optional<Book> getSelectedBook(@PathVariable Integer id) {
		try {
			return bookService.getSelectedBook(id);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No book available with selected id::" + id);
		}
	}

	@DeleteMapping("/book/id/{id}")
	public String deleteSelectedBook(@PathVariable Integer id) {
		try {
			return bookService.deleteSelectedBook(id);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("Unable to delete the book with selected id::" + id);
		}
	}

	@GetMapping("/sortbook/byfield/{sort}/withrecords/{size}")
	public List<Book> sortBooks(@PathVariable String sort, @PathVariable Integer size) {
		try {
			return bookService.sortBooks(sort, size);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No books available");
		}
	}

	@GetMapping("/example/id/{id}")
	public List<Book> getBookByExample(@PathVariable Integer id) {
		try {
			return bookService.getBookByExample(id);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No book available with selected id::" + id);
		}
	}

	@GetMapping("/book/by/{bookName}/author/{authorName}")
	public Book findBookByAuthorAndBookName(@PathVariable String bookName, @PathVariable String authorName) {
		try {
			return bookService.findBookByAuthorAndBookName(bookName, authorName);
		} catch (NoBookDataException e) {
			throw new NoBookDataException(
					"No book available with selected name::" + bookName + " and author::" + authorName);
		}
	}

	@GetMapping("/author/{authorName}")
	public List<Book> findBookByAuthorName(@PathVariable String authorName) {
		try {
			return bookService.findBookByAuthorName(authorName);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No book available with selected  author::" + authorName);
		}
	}

	@GetMapping("/book/by/{bookName}")
	public List<Book> findBookByBookName(@PathVariable String bookName) {
		try {
			return bookService.findBookByBookName(bookName);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No book available with selected  book name::" + bookName);
		}
	}

	@GetMapping("/book/by/query/{bookName}")
	public Book byQuery(@PathVariable String bookName) {
		try {
			return bookService.byQuery(bookName);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("No book available with selected  book name::" + bookName);
		}
	}

	@GetMapping("/book/byquery/{bookName}/author/{authorName}")
	public List<Book> findBookByAuthorAndBookNameQuery(@PathVariable String bookName, @PathVariable String authorName) {
		try {
			return bookService.findBookByBookNameAndAuthorName(bookName, authorName);
		} catch (NoBookDataException e) {
			throw new NoBookDataException(
					"No book available with selected name::" + bookName + " and author::" + authorName);
		}
	}

	@PostMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		try {
			return bookService.updateAuthorName(book);
		} catch (NoBookDataException e) {
			throw new NoBookDataException("Unable to update the book with selected book::" + book);
		}
	}
}
