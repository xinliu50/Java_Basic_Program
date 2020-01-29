package practice;
import java.util.*;
public class DayOne3 {
	public static void main(String[]args) {
		financialProgram();
	}
	
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	/*Financial application: payroll) Write a program that reads the following information
	and prints a payroll statement:
	Employeeís name (e.g., Smith)
	Number of hours worked in a week (e.g., 10)
	Hourly pay rate (e.g., 6.75)
	Federal tax withholding rate (e.g., 20%)
	State tax withholding rate (e.g., 9%)
	
	ex:
	Enter employee's name:
	Enter number of hours worked in a week:
	Enter hourly pay rate:
	Enter federal tax withholding rate:
	Enter state tax withholding rate:
	Employee Name: Smith
	Hours Worked: 10.0
	Pay Rate: $6.75
	Gross Pay: $67.5
	Deductions:
	Federal Withholding (20.0%): $13.5
	State Withholding (9.0%): $6.07
	Total Deduction: $19.57
	Net Pay: $47.92 */
	public static void financialProgram() {
		Scanner sc = new Scanner(System.in);
		println("Enter employee's name:");
		String name = sc.nextLine();
		println("Enter number of hours worked in a week:");
		int hour = sc.nextInt();
		println("Enter hourly pay rate:");
		double rate = sc.nextDouble();
		println("Enter federal tax withholding rate:");
		sc.nextLine();
		String fedString = sc.nextLine();
		fedString = fedString.substring(0,fedString.length()-1);
		double fedTax = Double.parseDouble(fedString)*0.01;
		println("Enter state tax withholding rate:");
		String stateString = sc.nextLine();
		
		stateString = stateString.substring(0,stateString.length()-1);
		double stateTax = Double.parseDouble(stateString)*0.01;
		println("Employee Name: " + name);
		println("Hours Worked: " + hour);
		println("Pay Rate: $" + rate);
		double gross = rate*hour;
		println("Gross Pay: $" + gross);
		println("Deductions:");
		double fed = rate*hour*fedTax;
		double state = rate*hour*stateTax;
		println("Federal Withholding (" + fedTax + "): $" + fed);
		println("State Withholding ( " + stateTax + "): $" + state);
		println("Total Deduction: $" + (fed + state));
		println("Net Pay: $" + (gross - fed - state));
	}
		
		
	
}
