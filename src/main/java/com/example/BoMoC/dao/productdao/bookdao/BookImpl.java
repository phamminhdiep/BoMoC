package com.example.BoMoC.dao.productdao.bookdao;

import com.example.BoMoC.model.product.Book;
import com.example.BoMoC.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImpl implements BookDao {
	private BookRepository bookRepository;
	@Autowired
	public BookImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book add(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book update(Integer id, Book book) {
		if(bookRepository.existsById(id)){
			book.setID(id);
			return bookRepository.save(book);
		}
		return null;
	}

	@Override
	public Optional<Book> getOne(Integer id) {
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findByTitleWithKeyword(String keyword) {
		return bookRepository.findByTitleContaining(keyword);
	}
}