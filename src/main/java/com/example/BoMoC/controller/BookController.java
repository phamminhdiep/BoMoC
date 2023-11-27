package com.example.BoMoC.controller;

import com.example.BoMoC.dao.productdao.bookdao.BookDao;
import com.example.BoMoC.model.product.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookDao bookDao;
    
    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> book = bookDao.getAll();
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        Optional<Book> book = bookDao.getOne(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getPersonsByKeyword(@RequestParam String keyword) {
        List<Book> bookList = bookDao.findByTitleWithKeyword(keyword);
        if (bookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book) {
        Book savedBook = bookDao.add(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
        return new ResponseEntity<>(bookDao.update(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
