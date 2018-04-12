package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ContactEntity;
@Repository
public interface IContactRepository extends JpaRepository<ContactEntity, Long>{

}
