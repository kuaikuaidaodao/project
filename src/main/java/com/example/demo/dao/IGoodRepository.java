package com.example.demo.dao;

import com.example.demo.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGoodRepository extends JpaRepository<GoodEntity, Long> {


}