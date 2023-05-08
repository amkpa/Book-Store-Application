package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.Entity.Book;
import com.book.Entity.MyBookList;
import com.book.service.BookService;
import com.book.service.MyBookListService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private MyBookListService mybookservice;

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

	@GetMapping("/my_books")
	public String getmybooks(Model model) {
		List<MyBookList> list = mybookservice.getAllBooks();
		model.addAttribute("book", list);
		return "mybook";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookbyId(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		mybookservice.save(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editbook/{id}")
	public String EditBook(@PathVariable("id") int id, Model model) {
		Book book = service.getBookbyId(id);
		model.addAttribute("book", book);
		return "BookEdit";
	}
	
	@RequestMapping("/deletebook/{id}")
	public String deletebook(@PathVariable("id")int id){
		service.deletebyId(id);
		return "redirect:/available_books";
		
	}

}
