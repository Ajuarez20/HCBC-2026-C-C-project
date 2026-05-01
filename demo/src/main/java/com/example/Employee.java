package com.example;

public abstract class Employee implements java.io.Serializable {
    protected String name;
    protected double skill; // the probability of completing a task 
    protected double salary;
    protected double performanceScore = 0;

    public Employee(String name, double skill) {
        this.name = name;
        this.skill = skill;
        this.skill = 0.6 + Math.random() * 0.4; //adds the random skill 
    }

    public abstract void evaluateTasks(TaskManager tm);
    public abstract String SelfAsses();
}
