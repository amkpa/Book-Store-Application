package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.Entity.MyBookList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList, Integer> {

}
