package com.example;
import java.util.List;
import java.util.Random;

public class SecurityGuard extends Employee {
    public final String occupation = "SecurityGuard";

    public SecurityGuard(String name, double skill) {
        super(name, skill);
        this.salary = 3500;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {
        List<Task> tasks = tm.assignTasks();
        Random r = new Random();

        for (Task t : tasks) {
            if (r.nextDouble() < skill) {
                this.performanceScore += 12;
            } else {
                this.performanceScore -= 6;
            }
        }
    }

    @Override
    public String SelfAsses() {
        return "Name: " + this.name + "\nOccupation: SecurityGuard" +
               "\nPerformanceScore: " + this.performanceScore + "\nSalary: " + this.salary + "\n";
    }
}
