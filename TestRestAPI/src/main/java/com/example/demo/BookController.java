package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping(value = "/addBook", consumes = {"application/json"})	
	public ResponseEntity<String> addBook(@RequestBody Book book){
		boolean isSaved = bookService.addBook(book);
		String msg = null;
		if(isSaved) {
			msg = "Book Saved";
			return new ResponseEntity<>(msg,HttpStatus.CREATED);
		}else {
			msg = "Failed to Saved";
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}					
		
	}
}
