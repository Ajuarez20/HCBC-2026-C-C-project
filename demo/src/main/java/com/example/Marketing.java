package com.example;
import java.util.List;
import java.util.Random;

public class Marketing extends Employee {
    public final String occupation = "Marketing";

    public Marketing(String name, double skill) {
        super(name, skill);
        this.salary = 5000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {
        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for (Task t : tasks) {
            if (r.nextDouble() < skill) {
                this.performanceScore += 18;
            } else {
                this.performanceScore -= 9;
            }
        }
    }

    @Override
    public String SelfAsses() {
        return "Name: " + this.name + "\nOccupation: Marketing" +
               "\nPerformanceScore: " + this.performanceScore + "\nSalary: " + this.salary + "\n";
    }
}
