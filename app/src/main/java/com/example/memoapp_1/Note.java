package com.example.memoapp_1;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private String title;
    private String body;
    private Date creationTime;
    private Integer color;

    private Note() {
    }

    public Note(String title, String body, Integer color) {
        this.title = title;
        this.body = body;
        this.color = color;
        this.creationTime=new Date();
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

    public Date getCreationTime() {
        return creationTime;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
