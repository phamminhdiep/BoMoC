package com.example.BoMoC.dao.productdao.bookdao;

import com.example.BoMoC.model.product.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookDao {
	Book update(Integer id, Book book);

	Book add(Book book);

	Optional<Book> getOne(Integer id);

	List<Book> getAll();

	void delete(Integer id);

	List<Book> findByTitleWithKeyword(String keyword);
}