package com.example;
import java.util.List;
import java.util.Random;

public class Custodian extends Employee {
	public final String occupation = "Custodian"; 

    public Custodian(String name, double skill) {
    	super(name,skill);
        this.salary = 2500;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {
        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for(Task t : tasks) {
            if(r.nextDouble() < skill) {
                this.performanceScore += 10;
            } else {
                this.performanceScore -= 5;
            }
        }

	}
		
	@Override
    public String SelfAsses(){
        return "Name: " + this.name + "\nOccupation: Custodian"+
		 "\nPerformanceScore: " + this.performanceScore + "\nsalary: " + this.salary +"\n";
    }

}

