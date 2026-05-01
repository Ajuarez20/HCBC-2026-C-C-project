package com.example;
import java.util.ArrayList;

public class PayrollReport {

    public static void main(String[] args) {
        generateReport();
    }
    public static  void generateReport() {

        ArrayList<Employee> employeesList = UserInterface.getEmployeeList();
        double totalPayroll = 0;

        System.out.println("===== COMPANY PAYROLL REPORT =====");

        for(Employee e : employeesList) {

            double pay = e.salary + (e.performanceScore * 10);
            totalPayroll += pay;

            System.out.println(
                e.getClass().getSimpleName() +
                " | " + e.name +
                " | " + e.Occupation +
                " | Score: " + e.performanceScore +
                " | Pay: $" + pay
            );
        }

        System.out.println("TOTAL COMPANY PAYROLL: $" + totalPayroll);
    }
    
    
}
		
