package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Banner;

public interface IBannerRepository extends JpaRepository<Banner, Long> {

}
