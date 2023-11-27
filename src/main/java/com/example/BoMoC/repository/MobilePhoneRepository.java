package com.example.BoMoC.repository;

import com.example.BoMoC.model.product.MobilePhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Integer> {
    List<MobilePhone> findByNameContaining(String keyword);
}