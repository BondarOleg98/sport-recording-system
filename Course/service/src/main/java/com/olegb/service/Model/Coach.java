package com.olegb.service.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    private UUID id;
    private String name;
    private String surname;
    private String rank;
    private Integer age;
    private String mail;

    @ManyToOne(fetch = FetchType.LAZY)
    private ArtStyle art_style;

    public Coach(){

    }

    public ArtStyle getArtStyle() {
        return art_style;
    }

    public void setArtStyle(ArtStyle artStyle) {
        this.art_style = artStyle;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public String getSurname(){return surname;}

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){this.id = id;}

}
