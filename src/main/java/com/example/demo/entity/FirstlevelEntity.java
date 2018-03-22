package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author li
 * @create 2018-03-21 9:34
 * @desc 一级目录
 **/
@Entity
@Table(name="first_level")
public class FirstlevelEntity {
    /**
     * id
     */
    private  Long firstId;
    /**
     * 一级目录名
     */
    private  String firstName;
    /**
     * 一级目录名 Enlish
     */
    private  String firstNameEnlish;

    /**
     * 无参构造方法
     */
    public FirstlevelEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "first_id", nullable = false, precision = 0 )
    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }
    @Basic
    @Column(name = "first_Name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Basic
    @Column(name = "first_Name_english")
    public String getFirstNameEnlish() {
        return firstNameEnlish;
    }

    public void setFirstNameEnlish(String firstNameEnlish) {
        this.firstNameEnlish = firstNameEnlish;
    }

}
