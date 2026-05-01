package com.example;
import java.util.List;
import java.util.Random;

public class SoftwareEngineer extends Employee {
    public final String occupation = "SoftwareEngineer";

    public SoftwareEngineer(String name, double skill) {
        super(name, skill);
        this.salary = 7000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {
        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for (Task t : tasks) {
            if (r.nextDouble() < skill) {
                this.performanceScore += 20;
            } else {
                this.performanceScore -= 10;
            }
        }
    }

    @Override
    public String SelfAsses() {
        return "Name: " + this.name + "\nOccupation: SoftwareEngineer" +
               "\nPerformanceScore: " + this.performanceScore + "\nSalary: " + this.salary + "\n";
    }
}
