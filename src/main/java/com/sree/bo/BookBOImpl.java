package com.sree.bo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sree.repo.BookRepository;
import com.sree.vo.Book;
import com.sree.vo.Status;

@Service
public class BookBOImpl implements BookBO {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public int deleteById(Long id) {
		return bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> findByNameAndPrice(String name, BigDecimal price) {
		return bookRepository.findByNameAndPrice(name, price);
	}

	@Override
	public Book findNameById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Status save(Book book) {
		Integer status;
		status = bookRepository.save(book);
		if(1 == status) {
			return new Status("Record Saved");
		} else {
			return new Status("Record Not Saved");
		}
	}

	@Override
	public Status update(Book book) {
		Book bookDetail = bookRepository.findById(book.getId());
		Integer status;
		if(bookDetail == null) {
			status = bookRepository.save(book);
		} else {
			status = bookRepository.update(book);
		}
		if(1 == status) {
			return new Status("Record Saved");
		} else {
			return new Status("Record Not Saved");
		}
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id);
	}

}
