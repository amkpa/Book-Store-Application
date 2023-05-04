package com.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	@GetMapping("/")
	public String home() {
		return "home"; 
	}
	@GetMapping("/book_register")
	public String bookregister() {
		return "bookregister";
	}
	@GetMapping("/available_books")
	public String available() {
		return "availablebooks";
		
	}
}
