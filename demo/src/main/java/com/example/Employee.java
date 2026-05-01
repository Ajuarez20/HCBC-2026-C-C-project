package com.example;
import java.util.ArrayList;
public class Employee implements java.io.Serializable {
    protected String name;
    protected double skill; // the probability of completing a task 
    protected double salary;
    protected double performanceScore = 100;
    protected ArrayList<Task> OnGoingTasks = new ArrayList<>();
    protected String Occupation;

    public Employee(String name, String occupation, double Salary) {
        this.name = name;
        this.skill = 0.3 + Math.random() * 0.7; //adds the random skill between 30 and 100
        this.Occupation = occupation;
    }

    public void TakeOnTask(Task task){

        Double chance = 0.3 + Math.random() * 0.7;

        if (chance > skill){
            task.Completeion = false;
            this.performanceScore -= 20;
        }else{
            task.Completeion = true;
            this.performanceScore -= 5;
        }

        this.OnGoingTasks.add(task);


    } 

    public String SelfAsses() {
        return "Name: " + this.name + "\nOccupation: "+ this.Occupation +
               "\nPerformanceScore: " + this.performanceScore + "\nSalary: " + this.salary +
                "\nTasks: " + this.OnGoingTasks.toString() +
                "\n";
    }
}
