package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	public Book findByName(String name);

}
