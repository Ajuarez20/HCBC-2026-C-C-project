package com.demo;

import java.util.List;


public class BusinessEmployee extends Employee {

    public BusinessEmployee(String name) {
        super(name);
        this.salary = 4000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {

        for (Task t : getTasks()) {

            if (Math.random() < skill) {
                performanceScore += 15;
            } else {
                performanceScore -= 5;
            }
        }
    }
}