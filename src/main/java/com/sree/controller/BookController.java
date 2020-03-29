package com.sree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sree.bo.BookBO;
import com.sree.vo.Book;
import com.sree.vo.Status;

@RestController
public class BookController {

    @Autowired
    private BookBO bookBO;

    // Find
    @GetMapping("/books")
    List<Book> findAll() {
        return bookBO.findAll();
    }

    // Save
    @PostMapping("/books")
    Status newBook(@RequestBody Book newBook) {
        return bookBO.save(newBook);
    }
    
    // Find
    @GetMapping("/books/{id}")
    Book findOne(@PathVariable Long id) {
        return bookBO.findById(id);
    }

    // Save or update
    @PutMapping("/books/{id}")
    Status saveOrUpdate(@RequestBody Book newBook) {
        return bookBO.save(newBook);
    }

    // update author only
	@PatchMapping("/books/{id}")
	Status patch(@RequestBody Book book, @PathVariable Long id) {
		return bookBO.update(book);
	}

    @DeleteMapping("/books/{id}")
	int deleteBook(@PathVariable Long id) {
    	return bookBO.deleteById(id);
    }

}
