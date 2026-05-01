package com.demo;
import java.util.ArrayList;
public class WorkForceFactory {


	    public static ArrayList<Employee> generateWorkforce() {

	        ArrayList<Employee> employees = new ArrayList<>();

	        // 10 custodians
	        for(int i = 0; i < 10; i++) {
	            employees.add(new Custodian("Custodian_" + i));
	        }

	        // 20 business employees
	        for(int i = 0; i < 20; i++) {
	            employees.add(new BusinessEmployee("Business_" + i));
	        }


	        return employees;
	    }
	}


