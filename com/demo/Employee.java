package com.demo;

import java.util.ArrayList;
import java.util.List;


public abstract class Employee implements java.io.Serializable {

    protected String name;
    protected double skill;
    protected double salary;
    protected double performanceScore;

    private List<Task> tasks = new ArrayList<>();

    public Employee(String name) {
        this.name = name;

        // skill between 0.6 and 1.0
        this.skill = 0.6 + Math.random() * 0.4;

        this.performanceScore = 0;
    }

    public String getName() {
        return name;
    }

    public double getSkill() {
        return skill;
    }

    public double getSalary() {
        return salary;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public abstract void evaluateTasks(TaskManager tm);

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " | " + name
                + " | Skill: " + String.format("%.2f", skill)
                + " | Score: " + performanceScore
                + " | $" + salary;
    }
}