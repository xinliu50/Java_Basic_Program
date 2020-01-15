package practice;
import java.util.*;

public class PracticeBasic {
	public static void main(String []args) {
		print("Input first number:");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
//		print("Input second number:");
//		int num2 = sc.nextInt();
		//OperationProgram op = new OperationProgram(num1,num2);
		
		Program pr = new Program(num1);
	}
	
	static class OperationProgram{
		static private int num1, num2;
		
		OperationProgram(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
			addition();
			sub();
			mul();
			division();
		}
		
		static public void addition() {
			print(num1 + " + " + num2 + " = " + (num1+num2)+"\n");
		}
		
		static public void sub() {
			print(num1 + " - " + num2 + " = " + (num1-num2)+"\n");
		}
		
		static public void mul() {
			print(num1 + " * " + num2 + " = " + (num1*num2)+"\n");
		}
		
		static public void division() {
			print(num1 + " / " + num2 + " = " + num1/num2+"\n");
		}
	}
	public static void print(Object o) {
		System.out.print(o);
	}
}

class Program{
	Program(int num){
		for(int i = 1; i <= 10; i ++) {
			System.out.print(num + " * " + i + " = " + num * i + "\n");
		}
	}
}
