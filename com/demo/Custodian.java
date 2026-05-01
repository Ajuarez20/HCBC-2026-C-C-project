package com.demo;

import java.util.List;
import java.util.Random;




public class Custodian extends Employee {

    public Custodian(String name) {
        super(name);
        this.salary = 2500;
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