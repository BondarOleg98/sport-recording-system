package com.olegb.service.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private UUID id;
    private Integer age;
    private String name;
    private String surname;
    private String belt;
    private String status;
    private Integer countWins;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private Coach coach;
    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private ArtStyle artStyle;

    public Student(){

    }

    public ArtStyle getArtStyle() {
        return artStyle;
    }

    public void setArtStyle(ArtStyle artStyle) {
        this.artStyle = artStyle;
    }

    public Integer getCountWins() {
        return countWins;
    }

    public String getStatus() {
        return status;
    }

    public void setCountWins(Integer countWins) {
        this.countWins = countWins;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  Coach getCoach() {
        return coach;
    }
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getBelt() {
        return belt;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
