package com.learn.Learn.model;

import com.learn.Learn.enums.TaskStatus;

public class Task {

    private String id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(String id, String title, String description, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void rename(String newTitle){
        this.title = newTitle;
    }
}
