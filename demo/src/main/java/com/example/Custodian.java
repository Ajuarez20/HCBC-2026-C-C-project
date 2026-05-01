package com.example;
import java.util.List;
import java.util.Random;

public class Custodian extends Employee {

	    public Custodian(String name, double skill) {
	        super(name, skill);
	        this.salary = 2500;
	    }

	    @Override
	    public void evaluateTasks(TaskManager tm) {
	        List<Task> tasks = tm.assignTasks();
	        Random r = new Random();

	        for(Task t : tasks) {
	            if(r.nextDouble() < skill) {
	                performanceScore += 10;
	            } else {
	                performanceScore -= 5;
	            }
	        }
	    }
	}
