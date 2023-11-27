package com.example.BoMoC.controller.ProductDao.ClothesDao;

import com.example.BoMoC.model.Product.Clothes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClothesDao {

    Clothes update(Integer id, Clothes clothes);

    Clothes add(Clothes clothes);

    Optional<Clothes> getOne(Integer id);

    List<Clothes> getAll();

    void delete(Integer id);
}