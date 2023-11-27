package com.example.BoMoC.repository;

import com.example.BoMoC.model.user.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FullNameRepository extends JpaRepository<FullName, Integer> {

}