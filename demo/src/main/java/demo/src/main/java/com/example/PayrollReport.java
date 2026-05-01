package demo.src.main.java.com.example;
import java.util.ArrayList;

public class PayrollReport {

	public static String generateReport() {

	    ArrayList<Employee> employeesList = UserInterface.getEmployeeList();
	    double totalPayroll = 0;

	    StringBuilder report = new StringBuilder();

	    report.append("===== COMPANY PAYROLL REPORT =====\n\n");

	    for(Employee e : employeesList) {

	        double pay = e.salary;
	        totalPayroll += pay;

	        report.append(
	            e.getClass().getSimpleName() +
	            " | " + e.name +
	            " | " + e.Occupation +
	            " | Score: " + e.performanceScore +
	            " | Pay: $" + pay + "\n"
	        );
	    }

	    report.append("\nTOTAL COMPANY PAYROLL: $" + totalPayroll);

	    return report.toString();
	}
}
		
