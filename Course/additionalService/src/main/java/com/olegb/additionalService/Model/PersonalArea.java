package com.olegb.additionalService.Model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "personal")
public class PersonalArea {

    @Id
    private UUID id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Competition> competitions;

    private String name;

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
