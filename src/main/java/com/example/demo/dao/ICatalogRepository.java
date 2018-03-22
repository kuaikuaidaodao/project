package com.example.demo.dao;

import com.example.demo.entity.FirstlevelEntity;
import com.example.demo.entity.UserinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatalogRepository extends JpaRepository<FirstlevelEntity, Long> {


}