package com.example;
import java.util.ArrayList;
public class WorkForce {

    public static ArrayList<Employee> generateWorkforce() {

        ArrayList<Employee> employees = new ArrayList<>();

	        // 10 custodians
        for(int i = 0; i < 10; i++) {
            employees.add(new Custodian("Custodian_" + i, randomSkill()));
        }

        // 20 business employees
        for(int i = 0; i < 20; i++) {
            employees.add(new BusinessOparations("Business_" + i, randomSkill()));
	    }


	    return employees;
   }

    private static double randomSkill() {
	    return 0.4 + Math.random() * 0.6; // 0.3 to 0.9

	}
}

