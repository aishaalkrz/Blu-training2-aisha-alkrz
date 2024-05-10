package com.aisha.Project_backEnd.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 
	    @PostMapping("/post")
	    public ResponseEntity<Book> createBook(@RequestBody Book book) {
	        Book createdBook = bookService.createBook(book);
	        return ResponseEntity.ok(createdBook);
	    }
	    
	    @GetMapping("/get")
	    public ResponseEntity<List<Book>> getAllBooks() {
	        List<Book> books = bookService.getAllBooks();
	        return new ResponseEntity<>(books, HttpStatus.OK);
	    }

	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable int id) {
	        try {
	            Book book = bookService.getBookById(id);
	            if (book != null) {
	                return ResponseEntity.ok(book);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (Exception e) {
	            // Handle exceptions (consider logging and returning a more informative error response)
	           System.out.println("Error fetching book with ID " + id + e); // Log the error for debugging
	            return ResponseEntity.internalServerError().build(); // Return 500 Internal Server Error
	        }
	    }

}
