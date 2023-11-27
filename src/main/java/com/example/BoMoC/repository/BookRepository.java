package com.example.BoMoC.repository;

import com.example.BoMoC.model.product.Book;
import com.example.BoMoC.model.product.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String keyword);
}