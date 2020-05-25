package com.example.edur.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Leave {

    private final UUID id;

    @NotBlank
    private final String type;

    @NotNull
    @Min(0)
    private final int duration;

    public Leave() {
        this(UUID.randomUUID(),"NA",0);
    }

    public Leave(UUID id, String type, int duration) {
        this.id = id;
        this.type = type;
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }
}
