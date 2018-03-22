package com.example.demo.dao;

import com.example.demo.entity.notepadEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface INotedRepository extends JpaRepository<notepadEntity, Long> {


}