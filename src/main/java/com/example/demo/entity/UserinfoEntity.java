package com.example.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author li
 * @create 2018-02-07 14:09
 * @desc 用户
 **/
@Entity
@Table(name="user_info")
public class UserinfoEntity {
    /**
     * id
     */
    private  Long id;
    /**
     * 用户名
     */
    private  String userName;
    /**
     * 密码
     */
    private  String password;
    /**
     * role
     */
    private  Long role;

    /**
     * 无参构造方法
     */

    public UserinfoEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "id", nullable = false, precision = 0 )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Basic
    @Column(name = "user_Name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "role")

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
}
