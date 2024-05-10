package com.aisha.Project_backEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisha.Project_backEnd.model.Book;
import com.aisha.Project_backEnd.services.BookService;

@RestController()
@RequestMapping("/books")
public class BookController {
	
	 @Autowired
	 private BookService bookService;

	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	    }
	 
	    @PostMapping("/create")
	    public ResponseEntity<Book> createBook(@RequestBody Book book) {
	        Book createdBook = bookService.createBook(book);
	        return ResponseEntity.ok(createdBook);
	    }


}
