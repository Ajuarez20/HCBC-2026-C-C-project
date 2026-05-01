package com.example;
import java.util.List;
import java.util.Random;

public class Accountant extends Employee {
    public final String occupation = "Accountant";

    public Accountant(String name, double skill) {
        super(name, skill);
        this.salary = 6000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {
        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for (Task t : tasks) {
            if (r.nextDouble() < skill) {
                this.performanceScore += 17;
            } else {
                this.performanceScore -= 12;
            }
        }
    }

    @Override
    public String SelfAsses() {
        return "Name: " + this.name + "\nOccupation: Accountant" +
               "\nPerformanceScore: " + this.performanceScore + "\nSalary: " + this.salary + "\n";
    }
}
