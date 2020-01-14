package practice;
import java.util.*;

public class PracticeBasic {
	public static void main(String []args) {
		print("Input first number:");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		print("Input second number:");
		int num2 = sc.nextInt();
		OperationProgram op = new OperationProgram(num1,num2);
	}
	
	public static void print(Object o) {
		System.out.print(o);
	}
	
	static class OperationProgram{
		private int num1, num2;
		
		public OperationProgram(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
			addition();
			sub();
			mul();
			division();
		}
		
		public void addition() {
			print(num1 + " + " + num2 + " = " + (num1+num2)+"\n");
		}
		
		public void sub() {
			print(num1 + " - " + num2 + " = " + (num1-num2)+"\n");
		}
		
		public void mul() {
			print(num1 + " * " + num2 + " = " + (num1*num2)+"\n");
		}
		
		public void division() {
			print(num1 + " / " + num2 + " = " + num1/num2+"\n");
		}
}

