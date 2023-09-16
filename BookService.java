package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

	private static List<Book> list=new ArrayList<>();
	static
	{
		list.add(new Book(1,"KABULIWALA","Rabindranath Tagore"));
		list.add(new Book(2,"Bhagavad Gita","Vyasa"));
		list.add(new Book(3,"Ramayana","Valmiki"));
	}
	
	//get all books
	public List<Book> getAllBooks()
	{
		return list;
	}
	//get single book
	public Book getBookById(int id)
	{
		Book a=null;
	    for(Book book:list)
	    {
	    	if(book.getId()==id)
	    	{
	    		a=book;
	    		break;
	    	}
	    }
		return a;
	}
	
	//adding a new Book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int bid)
	{
		list=list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
		
	}
	
	//update book
	public void updateBook(Book book, int bookId)
	{
		list=list.stream().map(b->{
		if(b.getId()==bookId)
		{
			b.setTitle(book.getTitle());
			b.setAuthor(book.getAuthor());
		}
		return b;
	}).collect(Collectors.toList());
	}
}
















