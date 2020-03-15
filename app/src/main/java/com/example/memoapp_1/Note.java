package com.example.memoapp_1;

import java.time.LocalDateTime;

public class Note {

    private String title;
    private String body;
    private LocalDateTime creationTime;
    private Integer color;

    private Note() {
    }

    public Note(String title, String body, Integer color) throws IllegalArgumentException {

        if (title == null || body == null){
            throw new IllegalArgumentException("Both title and body cannot be empty!");
        }

        this.title = title;
        this.body = body;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
