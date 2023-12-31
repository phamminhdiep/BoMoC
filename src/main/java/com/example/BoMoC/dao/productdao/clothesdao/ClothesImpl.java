package com.example.BoMoC.dao.productdao.clothesdao;

import com.example.BoMoC.model.product.Clothes;
import com.example.BoMoC.model.product.MobilePhone;
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

	@Override
	public List<Clothes> findByNameWithKeyword(String keyword) {
		return clothesRepository.findByNameContaining(keyword);
	}
}