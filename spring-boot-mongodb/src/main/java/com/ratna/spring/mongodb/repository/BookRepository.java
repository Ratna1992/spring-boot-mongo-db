package com.ratna.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratna.spring.mongodb.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
	public List<Book> findByBookName(String bookName);

	public Book findByBookNameAndAuthorName(String bookName, String authorName);

	public List<Book> findByAuthorName(String authorName);

	@Query("{'bookName':?0}")
	public Book findBookByBookName(String bookName);

	@Query("{'bookName':?0,'authorName':?1}")
	public List<Book> findBookByBookNameAndAuthorName(String bookName, String authorName);

}
