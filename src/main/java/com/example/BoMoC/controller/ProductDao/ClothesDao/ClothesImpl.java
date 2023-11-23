package com.example.BoMoC.controller.ProductDao.ClothesDao;

import com.example.BoMoC.Model.Product.Clothes;
import com.example.BoMoC.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesImpl implements ClothesDao {
	@Autowired
	public ClothesImpl(ClothesRepository clothesRepository) {
		this.clothesRepository = clothesRepository;
	}

	private ClothesRepository clothesRepository;

	@Override
	public Clothes add(Clothes clothes) {
		return clothesRepository.save(clothes);
	}

	@Override
	public Clothes update(Integer id, Clothes clothes) {
		if(clothesRepository.existsById(id)){
			clothes.setID(id);
			return clothesRepository.save(clothes);
		}
		return null;
	}

	@Override
	public Optional<Clothes> getOne(Integer id) {
		return clothesRepository.findById(id);
	}

	@Override
	public List<Clothes> getAll() {
		return clothesRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		clothesRepository.deleteById(id);
	}
}