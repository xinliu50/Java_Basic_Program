package practice;
import java.util.*;

public class PracticeBasic {
	public static void main(String []args) {
		print("Input first number:");
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
//		int num1 = sc.nextInt();
//		print("Input second number:");
//		int num2 = sc.nextInt();
		//OperationProgram op = new OperationProgram(num1,num2);
		
		//Program pr = new Program(num1);
		//PrintProgram printp = new PrintProgram();
		//PrintOperation op = new PrintOperation();
		PrintMath pm = new PrintMath(r);
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

class PrintProgram{
	PrintProgram(){
		System.out.println("   J    a   v     v  a ");
		System.out.println("   J   a a   v   v  a a");
		System.out.println("J  J  aaaaa   V V  aaaaa");
		System.out.println(" JJ  a     a   V  a     a");
	}
}
class PrintOperation{
	PrintOperation(){
		System.out.print(((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));
	}
}
class PrintMath{
	PrintMath(double r){
		System.out.print("Perimeter is = " + Math.PI * r * 2 + "\n");
		System.out.print("Area is = " + Math.PI * Math.pow(r, 2));
	}
}
