package com.olegb.service.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "art")
public class ArtStyle {
    @Id
    private UUID id;
    private String name;

    public ArtStyle(){

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
