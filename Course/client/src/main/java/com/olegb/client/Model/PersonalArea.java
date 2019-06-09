package com.olegb.client.Model;

import java.util.List;
import java.util.UUID;

public class PersonalArea {

    private UUID id;

    private List<Competition> competitions;

    private List<Schedule> schedules;

    private String name;

    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
