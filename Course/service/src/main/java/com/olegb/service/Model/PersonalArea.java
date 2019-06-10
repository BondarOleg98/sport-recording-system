package com.olegb.service.Model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "personal")
public class PersonalArea {

    @Id
    private UUID id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Schedule> schedules;

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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
