package com.example.demo.dao;

import com.example.demo.entity.cityinfoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author li
 * @create 2018-01-29 16:32
 * @desc 城市生活
 **/
public interface ICityinfoRepository extends JpaRepository<cityinfoEntity, Long> {
}
