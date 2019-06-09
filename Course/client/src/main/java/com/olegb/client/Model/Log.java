package com.olegb.client.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Action;

    private Date date;

    public Log(){

    }
    public Log(String Action,Date date){
        this.Action =Action;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Log(String Action){
        this.Action =Action;
    }

    public Integer getId() {
        return id;
    }

    public String getAction() {
        return Action;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setAction(String action) {
        Action = action;
    }

}
