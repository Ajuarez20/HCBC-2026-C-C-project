package com.example;
import java.util.List;
import java.util.Random;

public class BusinessOparations extends Employee {
	public final String occupation = "BusinessOparations"; 

    public BusinessOparations(String name, double skill) {
    	super(name,skill);
        this.salary = 4000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {

        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for(Task t : tasks) {
            if(r.nextDouble() < skill) {
                this.performanceScore += 15;
            } else {
                this.performanceScore -= 8;
            }
        }
    }

    @Override
    public String SelfAsses(){
        return "Name: " + this.name + "\nOccupation: BusinessOparations"+
         "\nPerformanceScore: " + this.performanceScore + "\nsalary: " + this.salary +"\n";
    }

}
