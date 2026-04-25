package org.example.model.Parts_of_the_mission;

import java.time.LocalDateTime;

public class OperationTimeline {
    private LocalDateTime timestamps;
    private String type;
    private String description;

    public OperationTimeline() {}

    public OperationTimeline(LocalDateTime timestamps, String type, String description) {
        this.timestamps = timestamps;
        this.type = type;
        this.description = description;
    }

    public LocalDateTime getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(LocalDateTime timestamps) {
        this.timestamps = timestamps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
