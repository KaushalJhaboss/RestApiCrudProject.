package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;
	
	//get all books handler
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		
		return this.bookservice.getAllBooks();
	}
	
	//get single book handler
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookservice.getBookById(id);
	}
	
	//new book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b=this.bookservice.addBook(book);
		System.out.println(book);
		return b;
	}
	
	//delete book handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookservice.deleteBook(bookId);
		
	}
	
	//update book handler
	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		this.bookservice.updateBook(book,bookId);
	}
}






