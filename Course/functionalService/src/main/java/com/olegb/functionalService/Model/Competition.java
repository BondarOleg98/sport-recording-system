package com.olegb.functionalService.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "competition")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String t;
    private String country;
    private String city;

    public Competition(){}

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getCompData() {
        return t;
    }

    public void setTime(String compData) {
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
