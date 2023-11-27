package com.example.BoMoC.dao.productdao.mobilephonedao;

import com.example.BoMoC.model.product.MobilePhone;
import com.example.BoMoC.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobilePhoneImpl implements MobilePhoneDao {
	@Autowired
	public MobilePhoneImpl(MobilePhoneRepository mobilePhoneRepository) {
		this.mobilePhoneRepository = mobilePhoneRepository;
	}

	private MobilePhoneRepository mobilePhoneRepository;
	@Override
	public MobilePhone add(MobilePhone mobilePhone) {
		mobilePhoneRepository.save(mobilePhone);
		return mobilePhone;
	}

	@Override
	public MobilePhone update(Integer id, MobilePhone mobilePhone) {
		if(mobilePhoneRepository.existsById(id)){
			mobilePhone.setID(id);
			return mobilePhoneRepository.save(mobilePhone);
		}
		return null;
	}

	@Override
	public Optional<MobilePhone> getOne(Integer id) {
		return mobilePhoneRepository.findById(id);
	}

	@Override
	public List<MobilePhone> getAll() {
		return mobilePhoneRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		mobilePhoneRepository.deleteById(id);
	}

	@Override
	public List<MobilePhone> findByNameWithKeyword(String keyword) {
		return mobilePhoneRepository.findByNameContaining(keyword);
	}
}
