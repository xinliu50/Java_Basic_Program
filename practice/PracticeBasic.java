package practice;
import java.util.*;

public class PracticeBasic {
	public static void main(String []args) {
		print("Input first number:");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		print("Input second number:");
		int num2 = sc.nextInt();
		print(num1 + " + " + num2 + " = " + (num1+num2)+"\n");
		print(num1 + " - " + num2 + " = " + (num1-num2)+"\n");
		print(num1 + " * " + num2 + " = " + (num1*num2)+"\n");
		print(num1 + " / " + num2 + " = " + num1/num2+"\n");

	}
	public static void print(Object o) {
		System.out.print(o);
	}

}
