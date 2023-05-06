package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.Entity.Book;
import com.book.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo repo;

	public void save(Book book) {
		repo.save(book);
	}
	
	public List<Book> fetch() {
		return repo.findAll();
		
	}

}
