package application;

public class Custodian extends Employee {

    public Custodian(String name) {
        super(name);
        this.salary = 2500;
    }

    @Override
    public void evaluateTasks(TaskManager tm) {

        for (Task t : tm.assignTasks()) {

            if (Math.random() < skill) {
                performanceScore += 10;
            } else {
                performanceScore -= 5;
            }
        }
    }
}