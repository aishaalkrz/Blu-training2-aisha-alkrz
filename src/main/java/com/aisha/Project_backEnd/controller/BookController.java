package com.aisha.Project_backEnd.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	        Book createdBook = bookService.create(book);
	        if (createdBook == null) {
	             return ResponseEntity.noContent().build();
	         } else {
	             return ResponseEntity.ok(createdBook);
	         }
	    }
	    
	    @GetMapping("/get")
	    public ResponseEntity<List<Book>> getAllBooks() {
	        List<Book> books = bookService.getAll();
	        if (books.isEmpty()) {
	             return ResponseEntity.noContent().build();
	         } else {
	             return ResponseEntity.ok(books);
	         }
	    }

	    
	    @GetMapping("/get/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable int id) {
	            Book book = bookService.getById(id);
	            if (book == null) {
		             return ResponseEntity.noContent().build();
		         } else {
		             return ResponseEntity.ok(book);
		         }
	    }
	    @GetMapping("/search")
	    public ResponseEntity<List<Book>> searchBooks(@RequestParam("keyword") String keyword) {
	    	 List<Book> foundBooks = bookService.searchBooks(keyword);
	         if (foundBooks.isEmpty()) {
	             return ResponseEntity.noContent().build();
	         } else {
	             return ResponseEntity.ok(foundBooks);
	         }
	    }
	    
	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteBookById(@PathVariable("id") int id) {
	    	 bookService.deleteById(id);
	    	 return ResponseEntity.ok("Book with id " + id + " has been deleted successfully");
	      
	    }

}
