package com.example;

public abstract class Employee implements java.io.Serializable {
    protected String name;
    protected double skill; // the probability of completing a task 
    protected double salary;
    protected double performanceScore = 0;

    public Employee(String name, double skill) {
        this.name = name;
        this.skill = skill;
    }

    public abstract void evaluateTasks(TaskManager tm);
