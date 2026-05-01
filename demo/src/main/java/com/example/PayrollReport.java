package com.example;
import java.util.ArrayList;

public class PayrollReport {

    public static void main(String[] args) {
        generateReport();
    }
    public static String generateReport() {

        ArrayList<Employee> employeesList = UserInterface.getEmployeeList();
        double totalPayroll = 0;
        StringBuilder report = new StringBuilder(""); 

        report.append("===== COMPANY PAYROLL REPORT =====");

        for(Employee e : employeesList) {

            double pay = e.salary + (e.performanceScore * 10);
            totalPayroll += pay;

            String info = " \n | " + e.name + " | " + e.Occupation +  " | Score: " + e.performanceScore + " | Pay: $" + pay;

            report.append(info);
        }

        System.out.println("TOTAL COMPANY PAYROLL: $" + totalPayroll);

        return report.toString();
    }
    
    
}
		
