package com.example.BoMoC.repository;

import com.example.BoMoC.model.product.Book;
import com.example.BoMoC.model.product.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Integer> {
    List<Clothes> findByNameContaining(String keyword);
}

