package com.sree.repo;

import java.math.BigDecimal;
import java.util.List;

import com.sree.vo.Book;

public interface BookRepository {

	int save(Book book);

	int update(Book book);

	int deleteById(Long id);

	List<Book> findAll();

	List<Book> findByNameAndPrice(String name, BigDecimal price);

	Book findById(Long id);

	String findNameById(Long id);

	int count();

}
