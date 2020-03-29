package com.sree.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sree.vo.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from books", Integer.class);
    }

	@Override
	public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete books where id = ?",
                id);
    }

	@Override
	public List<Book> findAll() {
		return jdbcTemplate.query("select * from books", 
				(rs, rowNum) -> new Book(rs.getLong("id"),
										 rs.getString("name"), 
										 rs.getBigDecimal("price")));
	}

	@Override
	public List<Book> findByNameAndPrice(String name, BigDecimal price) {
        return jdbcTemplate.query(
                "select * from books where name like ? and price <= ?",
                new Object[]{"%" + name + "%", price},
                (rs, rowNum) ->
                        new Book(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getBigDecimal("price")
                        )
        );
    }

	@Override
	public String findNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from books where id = ?",
                new Object[]{id},
                String.class
        );
    }

	@Override
	public int save(Book book) {
		return jdbcTemplate.update("insert into books (name, price) values(?,?)", book.getName(), book.getPrice());
	}

	@Override
	public int update(Book book) {
		return jdbcTemplate.update("update books set price = ?,name = ? where id = ?", book.getPrice(), book.getName(), book.getId());
	}

	@Override
	public Book findById(Long id) {
		return jdbcTemplate.queryForObject("select * from books where id = ?", new Object[] { id },
				(rs, rowNum) -> (new Book(rs.getLong("id"),
										  rs.getString("name"), 
										  rs.getBigDecimal("price"))));
	}

}
