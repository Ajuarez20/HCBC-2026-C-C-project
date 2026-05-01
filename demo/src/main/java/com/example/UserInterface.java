package com.example;
import java.util.ArrayList;
import java.util.Arrays;

public class UserInterface{
    public static ArrayList<Employee> Employeelist = new ArrayList<>();

    public static void main(String[] args) {
        Employee e1 = new Custodian("ahmed", 12.5);
        Employeelist.add(e1);
        Employee e2 = new Custodian("malasi", 12.5);
        Employeelist.add(e2);
        FireEmployees();
    }

    public static void HireEmployee(){

        //pronmpt user via Gui to enter employee specs
        //name
        //age
        // select occupation
        
        /*
        if (occuoation == Custodian){
            Custodian Employee = new Custodian(null, 0)
        }else if (occuoation == BusinessEmployee){
            BusinessEmployee Employee = new BusinessEmployee(null, 0)
        }

        Employeelist.add(Employee)

        */

        //that is the idea

    }

    public static void FireEmployees(){

        // add a gui Option that protects certin employees from being fired

        StringBuilder info = new StringBuilder("");

        for (Employee e : Employeelist) {
            
            info.append(e.SelfAsses());

        }

        info.append("I must layoff an employee/s which employee/s should I layoff \nRespond with only the Employee/s names (if more than one employee separate thier name by commas) exactly as it was written");
        System.out.println(info);

        String response = model.chatbot.chat(info.toString());
        System.out.println(response);

        String[] names = response.split("[,\\s]+");
        ArrayList<String> toBeFired = new ArrayList<>(Arrays.asList(names));

        Employeelist.removeIf(e -> {
            if (toBeFired.contains(e.name)) {
                System.out.println(e.name + " has been fired.");

                // TODO: update GUI here

                return true;
            }
            return false;
        });

    }

    

}