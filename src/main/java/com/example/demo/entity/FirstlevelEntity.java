package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstlevelEntity that = (FirstlevelEntity) o;
        return Objects.equals(firstId, that.firstId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(firstNameEnlish, that.firstNameEnlish);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstId, firstName, firstNameEnlish);
    }
}
