package com.example.BoMoC.dao.productdao.mobilephonedao;

import com.example.BoMoC.model.product.MobilePhone;

import java.util.List;
import java.util.Optional;

public interface MobilePhoneDao {
	MobilePhone add(MobilePhone mobilePhone);

	MobilePhone update(Integer id, MobilePhone mobilePhone);

	Optional<MobilePhone> getOne(Integer id);

	List<MobilePhone> getAll();

	void delete(Integer id);

	List<MobilePhone> findByNameWithKeyword(String keyword);
}