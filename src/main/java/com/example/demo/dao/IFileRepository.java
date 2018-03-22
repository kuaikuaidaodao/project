package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FileEntity;

public interface IFileRepository extends JpaRepository<FileEntity, Long>{

}
