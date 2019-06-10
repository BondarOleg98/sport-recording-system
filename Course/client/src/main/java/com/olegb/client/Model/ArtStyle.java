package com.olegb.client.Model;

import java.util.UUID;

public class ArtStyle {
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
