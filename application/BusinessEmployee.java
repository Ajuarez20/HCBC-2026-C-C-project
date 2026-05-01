package application;

import java.util.*;

public class BusinessEmployee extends Employee {

    public BusinessEmployee(String name) {
        super(name);
        this.salary = 4000;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {

        for (Task t : tm.assignTasks()) {

            if (Math.random() < skill) {
                performanceScore += 15;
            } else {
                performanceScore -= 8;
            }
        }
    }
}