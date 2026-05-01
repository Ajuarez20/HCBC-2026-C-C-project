package com.demo;

import java.util.HashMap;


public class Task {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}