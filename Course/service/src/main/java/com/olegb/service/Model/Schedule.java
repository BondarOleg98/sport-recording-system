package com.olegb.service.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Coach coach;


    private String timeClass;
    private String day;

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public UUID getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }
}
