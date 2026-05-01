package com.example;
import java.util.ArrayList;

public class PayrollReport {

	    private ArrayList<Employee> employees;

	    public PayrollReport(ArrayList<Employee> employees) {
	        this.employees = employees;
	    }

	
    public void generateReport() {

        double totalPayroll = 0;

        System.out.println("===== COMPANY PAYROLL REPORT =====");

        for(Employee e : employees) {

            double pay = e.salary + (e.performanceScore * 10);
            totalPayroll += pay;

            System.out.println(
                e.getClass().getSimpleName() +
                " | " + e.name +
                " | Score: " + e.performanceScore +
                " | Pay: $" + pay
            );
        }

        System.out.println("TOTAL COMPANY PAYROLL: $" + totalPayroll);
    }
    
    
}
		
