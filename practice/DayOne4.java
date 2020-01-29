package practice;

import java.util.*;
public class DayOne4 {
	public static void main(String[]args) {
		
		//printFormat(0,10);
		verifyPassword();
	}
	
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	/*1. Using only the programming techniques you learned in this lesson, 
	 * write an application that calculates the squares and cubes of between 
	 * two numbers and prints the resulting values in table format, as shown below. 
	number square cube  [ dont use any java built in method]
	enter two enters : 0  10
	
	0               0             0 
	1               1             1 
	2               4             8 
	.
	.
	.
	10            100         1000*/
	public static void printFormat(int s, int e) {
		for(int i = s; i <= e; i ++) {
			println(i + "			" + i*i + "			" + i*i*i);
		}
	}
	/*1. (Check password ) Some websites impose certain rules for passwords. Write a
	method that checks whether a string is a valid password. Suppose the password
	rules are as follows:
	¶ A password must have at least eight characters.
	¶ A password consists of only letters and digits.
	¶ A password must contain at least two digits.
	Write a program that prompts the user to enter a password and displays Valid
	Password if the rules are followed or Invalid Password otherwise.*/
	public static void verifyPassword() {
		Scanner sc = new Scanner(System.in);
		println("Enter your password:");
		String pass = sc.nextLine();
		int count = 0;
		if(pass.length() < 8) {
			println("Invalid password");
			return;
		}
		else {
			for(int i = 0; i < pass.length(); i ++) {
				if(!(pass.charAt(i)>=48 && pass.charAt(i)<=57 ||  
						pass.charAt(i)>=65 && pass.charAt(i)<=90 || 
						pass.charAt(i)>=97 && pass.charAt(i)<=122)) {
					println("Invalid password");
					return;
				}
				if(pass.charAt(i)>=48 && pass.charAt(i)<=57)
					count ++;
			}
		}
		if(count < 2) {
			println("Invalid password");
			return;
		}
		println("Valid Password");
	}
}
