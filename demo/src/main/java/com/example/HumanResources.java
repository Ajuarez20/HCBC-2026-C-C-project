package com.example;
import java.util.List;
import java.util.Random;

public class HumanResources extends Employee {
    public final String occupation = "HumanResources";

    public HumanResources(String name, double skill) {
        super(name, skill);
        this.salary = 5500;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {
        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for (Task t : tasks) {
            if (r.nextDouble() < skill) {
                this.performanceScore += 16;
            } else {
                this.performanceScore -= 7;
            }
        }
    }

    @Override
    public String SelfAsses() {
        return "Name: " + this.name + "\nOccupation: HumanResources" +
               "\nPerformanceScore: " + this.performanceScore + "\nSalary: " + this.salary + "\n";
    }
}
