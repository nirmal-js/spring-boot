package com.sree.bo;

import java.math.BigDecimal;
import java.util.List;

import com.sree.vo.Book;
import com.sree.vo.Status;

public interface BookBO {
	
    Status save(Book book);

    Status update(Book book);

    int deleteById(Long id);

    List<Book> findAll();

    List<Book> findByNameAndPrice(String name, BigDecimal price);

    Book findById(Long id);

    Book findNameById(Long id);

}
