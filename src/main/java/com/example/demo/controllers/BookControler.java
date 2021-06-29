package com.example.demo.controllers;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;


@RestController
public class BookControler {

	@Autowired
	public BookRepository bookRepository;
	
	@GetMapping(value="/all") 
	public List<Book> getAllBooks(){
		
		return bookRepository.findAll();
	}
	@PostMapping(value = "/create")
	public String createBook(@RequestBody Book book){
		
		Book insertedBook = bookRepository.insert(book);
		
	    return "Book created " + insertedBook.getTitle();
	    
	}
	
}
