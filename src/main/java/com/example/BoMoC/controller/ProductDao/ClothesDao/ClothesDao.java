package com.example.BoMoC.controller.ProductDao.ClothesDao;

import com.example.BoMoC.Model.Product.Clothes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClothesDao {

	public Clothes update(Integer id, Clothes clothes);

	public Clothes add(Clothes clothes);

	public Optional<Clothes> getOne(Integer id);

	public List<Clothes> getAll();

	public void delete(Integer id);
}