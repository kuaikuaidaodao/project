package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author li
 * @create 2018-01-29 14:19
 * @desc dis
 **/
@Entity
@Table(name="cityinfo")
public class cityinfoEntity {
    private Long id;
    private  String title;
    private  String phone;
    private  String  username;
    private  String classify;
    private  String  cityinfoTime;
    private String checked;
    private String content;
    public cityinfoEntity() {
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Basic
    @Column(name = "classify")
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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
    @Column(name = "cityinfo_time")

    public String getCityinfoTime() {
        return cityinfoTime;
    }

    public void setCityinfoTime(String cityinfoTime) {
        this.cityinfoTime = cityinfoTime;
    }



    @Basic
    @Column(name = "checked")
    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cityinfoEntity that = (cityinfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(username, that.username) &&
                Objects.equals(classify, that.classify) &&
                Objects.equals(cityinfoTime, that.cityinfoTime) &&
                Objects.equals(checked, that.checked);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, phone, username, classify, cityinfoTime, checked);
    }
}
