package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author li
 * @create 2018-03-21 9:34
 * @desc 级目录
 **/
@Entity
@Table(name="second_level")
public class SecondlevelEntity {
    /**
     * id
     */
    private  Long secondId;
    /**
     * 一级id
     */
    private  Long firstId;
    /**
     * 二级目录名
     */
    private  String secondName;
    /**
     * 二级目录名 Enlish
     */
    private  String secondNameEnlish;

    /**
     * 无参构造方法
     */
    public SecondlevelEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "second_Id", nullable = false, precision = 0 )

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }
    @Basic
    @Column(name = "first_id")
    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }
    @Basic
    @Column(name = "second_Name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    @Basic
    @Column(name = "second_Name_english")
    public String getSecondNameEnlish() {
        return secondNameEnlish;
    }

    public void setSecondNameEnlish(String secondNameEnlish) {
        this.secondNameEnlish = secondNameEnlish;
    }
}
