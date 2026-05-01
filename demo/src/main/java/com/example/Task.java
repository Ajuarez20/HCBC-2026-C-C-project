package com.example;

public class Task implements java.io.Serializable {
    final private  String title;
    final private String description;
    public Boolean Completeion = false;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nTask title: " + this.title + "\ntask Discription: " + this.description + "\ntask Completed:" + this.Completeion;
    }
}