package practice;
import java.util.*;

//takes 3 numbers from user and print the average
public class SimpleProgram {
	public static void main(String []args) {
		//addBinary();
		int[] a = {0,1,2,3,4,5};
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j ++) {
				if(j == 1)
					break;
				print(a[i]);
				
			}
		}
	}
	public static void print(Object o) {
		System.out.print(o);
	}	
	public static void ave() {
		Scanner sc = new Scanner(System.in);
		print("enter your first number: \n");
		int num1 = sc.nextInt();
		print("enter your second number: \n");
		int num2 = sc.nextInt();
		print("enter your third number: \n");
		int num3 = sc.nextInt();
		print((num1+num2+num3)/3.0);
		//return (num1+num2+num3)/3.0;
	}
	public static void addBinary() {
		Scanner sc = new Scanner(System.in);
		print("enter your first number: \n");
		int num1 = sc.nextInt();
		print("enter your second number: \n");
		int num2 = sc.nextInt();
		int carry = 0;
		int sum = 0;
		ArrayList<Integer> ls = new ArrayList<Integer>();
		
		while(num1 != 0 && num2 != 0) {
			sum = num1%10 + num2%10 + carry;
			
			if(sum >= 2)
				carry = 1;
			else 
				carry = 0;
			
			ls.add(sum%2);
			num1 = num1/10;
			num2 = num2/10;
		}
		while(num1/10 != 0) {
			
			ls.add(num1%10);
			num1 = num1/10;
		}
		while(num2/10 != 0) {
			
			ls.add(num2%10);
			num2 = num2/10;
		}
		if(carry == 1)
			ls.add(carry);
		for(int i = 0; i < ls.size(); i ++) {
			print(ls.get(i) + ", ");
		}
		int result = 0;
		for(int i = ls.size()-1; i >= 0; i --) {
			result += ls.get(i)*Math.pow(10, i);
		}
		
		print("Sum of two binary numbers: " + result);
	}
	
}
