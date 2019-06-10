package com.olegb.client.Model;

import java.util.UUID;

public class Coach {
    private UUID id;
    private String name;
    private String surname;
    private String rank;
    private Integer age;
    private String mail;
    private ArtStyle artStyle;

    public Coach(){

    }

    public ArtStyle getArtStyle() {
        return artStyle;
    }

    public void setArtStyle(ArtStyle artStyle) {
        this.artStyle = artStyle;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
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
