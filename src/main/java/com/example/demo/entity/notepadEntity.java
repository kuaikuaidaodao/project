package com.example.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author li
 * @create 2018-01-29 9:41
 * @desc dis
 **/
@Entity
@Table(name="notepad")
public class notepadEntity {
    private  Long id;

    private  String title;

    private  String content;

    private String  name;

    private  String date;

    private  String  share;

    private  String  companyName;

    private  String  userKey;

    public notepadEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "ID", nullable = false, precision = 0 )
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }




    @Basic
    @Column(name = "title")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Basic
    @Column(name = "share")
    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    @Basic
    @Column(name = "company_Name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "user_Key")
    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
