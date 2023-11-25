package com.example.BoMoC.repository;

import com.example.BoMoC.Model.User.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}