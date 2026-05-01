package com.example;
import java.util.List;
import java.util.Random;

import okhttp3.internal.concurrent.Task;

public class BusinessEmployee extends Employee {
	

    public BusinessEmployee(String name, double skill) {
    	super(name,skill);
        this.salary = 4000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {

        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for(Task t : tasks) {
            if(r.nextDouble() < skill) {
                performanceScore += 15;
            } else {
                performanceScore -= 8;
            }
        }
    }
}
