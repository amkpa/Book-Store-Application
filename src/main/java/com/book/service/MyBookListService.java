package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.Entity.MyBookList;
import com.book.repo.MyBookRepo;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepo repo;
	
	public void save(MyBookList book) {
		repo.save(book);
	}
	
	public List<MyBookList> getAllBooks() {
		return repo.findAll();
		
	}
	public void deletebyid(int id) {
		repo.deleteById(id);
	}

}
