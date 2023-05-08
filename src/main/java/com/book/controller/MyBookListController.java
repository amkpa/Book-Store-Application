package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService mylist;

	@RequestMapping("/deletemylist/{id}")
	public String deletemyList(@PathVariable("id") int id) {
		mylist.deletebyid(id);
		return "redirect:/my_books";

	}

}
