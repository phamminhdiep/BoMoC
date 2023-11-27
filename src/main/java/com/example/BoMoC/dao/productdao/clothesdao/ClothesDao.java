package com.example.BoMoC.dao.productdao.clothesdao;

import com.example.BoMoC.model.product.Clothes;
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