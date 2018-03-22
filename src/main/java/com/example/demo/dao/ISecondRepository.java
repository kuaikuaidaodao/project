package com.example.demo.dao;

import com.example.demo.entity.FirstlevelEntity;
import com.example.demo.entity.SecondlevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecondRepository extends JpaRepository<SecondlevelEntity, Long> {


}