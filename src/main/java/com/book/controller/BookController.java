package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.Entity.Book;
import com.book.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookregister() {
		return "bookregister";
	}

	@GetMapping("/available_books")
	public ModelAndView available() {
		List<Book> list = service.fetch();
		ModelAndView view = new ModelAndView();
		view.setViewName("availablebooks");
		view.addObject("book", list);
		return view;
//		return "availablebooks";
	}

	@PostMapping("/save")
	public String addbook(@ModelAttribute Book book) {
		service.save(book);
		return "redirect:/available_books";

	}
}
