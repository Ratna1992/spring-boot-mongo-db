package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ratna.spring.mongodb.exceptions.NoBookDataException;
import com.ratna.spring.mongodb.model.Book;
import com.ratna.spring.mongodb.repository.BookRepository;

@Service
public class BookService implements BookServiceInterface {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	public String saveBook(@RequestBody Book book) throws NoBookDataException {
		Book save = bookRepository.save(book);
		return "Saved the book" + save.getBookName() + " into Collection";
	}

	public List<Book> retrieveBooks() throws NoBookDataException {
		return mongoTemplate.findAll(Book.class);
	}

	public Optional<Book> getSelectedBook(Integer id) throws NoBookDataException {
		return bookRepository.findById(id);
	}

	public String deleteSelectedBook(Integer id) throws NoBookDataException {
		try {
			bookRepository.deleteById(id);
			return "deleted";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Book> sortBooks(String bookName, Integer size) throws NoBookDataException {
		PageRequest req = PageRequest.of(0, size, Sort.by(bookName));
		return bookRepository.findAll(req).toList();
	}

	public List<Book> getBookByExample(Integer id) throws NoBookDataException {
		Book book = new Book();
		book.setId(id);
		Example<Book> of = Example.of(book);
		return bookRepository.findAll(of);
	}

	public Book findBookByAuthorAndBookName(String bookName, String authorName) throws NoBookDataException {
		return bookRepository.findByBookNameAndAuthorName(bookName, authorName);
	}

	public List<Book> findBookByAuthorName(String authorName) throws NoBookDataException {
		return bookRepository.findByAuthorName(authorName);
	}

	public List<Book> findBookByBookName(String bookName) throws NoBookDataException {
		return bookRepository.findByBookName(bookName);
	}

	public Book byQuery(String bookName) throws NoBookDataException {
		return bookRepository.findBookByBookName(bookName);
	}

	public List<Book> findBookByBookNameAndAuthorName(String bookName, String authorName) throws NoBookDataException {
		return bookRepository.findBookByBookNameAndAuthorName(bookName, authorName);
	}

	public Book updateAuthorName(Book book) throws NoBookDataException {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(book.getId()));
		Update update = new Update();
		update.set("authorName", book.getAuthorName());
		return mongoTemplate.findAndModify(query, update, Book.class);
	}

}
