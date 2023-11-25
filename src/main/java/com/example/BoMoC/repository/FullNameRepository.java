package com.example.BoMoC.repository;

import com.example.BoMoC.Model.User.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FullNameRepository extends JpaRepository<FullName, Integer> {

}