package practice;
import java.util.*;

public class DayOne2 {
	public static void main(String[]args) {
		//***Lottery program
		/*int re = reward();
		print("Your reward is " + re + "\n");*/
		
		//***(Count positive and negative numbers and compute the average of numbers) 
		//countNumber();
		
		//***print patterns
		//printA();
		//printB();
		//printC();
		//printD();
		
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	/*(Game: lottery) Revise Listing 3.9, Lottery.java, to generate a lottery of a threedigit
	number. The program prompts the user to enter a three-digit number and
	determines whether the user wins according to the following rules:
	1. If the user input matches the lottery number in the exact order, the award is
	$10,000.
	2. If all the digits in the user input match all the digits in the lottery number, the
	award is $3,000.
	3. If one digit in the user input matches a digit in the lottery number, the award is
	$1,000.*/
	
	public static int reward(){
		int[] win = lottery();
		int[] user = new int[3];
		int count = 0;
		print("Lottery is:");
		for(int i = 0; i <= 2; i ++) {
			print(win[i]);
		}
		print("\n");
		Scanner sc = new Scanner(System.in);
		println("Please enter a three-digit number");
		int result = sc.nextInt();
		for(int i = 2; i >= 0; i --) {
			if(result%10 == win[i]) {
				count ++;
			}
			user[i] = result%10;
			result = result/10;
		}
		
		if(count == 3)
			return 10000;
		count = 0;
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(user[i] == win[j])
					count ++;
			}
		}
		if(count == 3)
			return 3000;
		if(count == 1)
			return 1000;
		return 0;
	}
	//!!
	//!!
	//!!!I can't find Lottery.java file so I implemented my own lottery method. I hope it's ok!
	public static int[] lottery() {
		int first = (int) (Math.random()*10);
		int second = (int) (Math.random()*10);
		while(second == first)
			second = (int) (Math.random()*10);
		
		int third = (int) (Math.random()*10);
		while(third == first || third == second)
			third = (int) (Math.random()*10);
		return new int[]{first,second,third};
	}
	/*2. (Count positive and negative numbers and compute the average of numbers) Write
	a program that reads an unspecified number of integers, determines how many
	positive and negative values have been read, and computes the total and average of
	the input values (not counting zeros). Your program ends with the input 0. Display
	the average as a floating-point number. Here is a sample run:
	Enter an integer, the input ends if it is 0:1 2 -1 3 0
	The number of positives is 3
	The number of negatives is 1
	The total is 5
	The average is 1.25
	
	or
	
	Enter an integer, the input ends if it is 0:
	No numbers are entered except 0
	0*/
	
	public static void countNumber() {
		Scanner sc = new Scanner(System.in);
		println("Enter an integer, the input ends if it is 0:");
		int num = sc.nextInt();
		int pos = 0;
		int neg = 0;
		int sum = 0;
		while(num != 0) {
			if(num < 0)
				neg ++;
			else
				pos ++;
			sum += num;
			num = sc.nextInt();
		}
		int total = pos + neg + 1;
		if(total == 1)
			println("No numbers are entered except 0");
		else {
			println("The sum is " + sum);
			println("The number of positives is " + pos) ;
			println("The number of negatives is " + neg);
			println("The total is " + total);
			println("The average is " + (float)sum/(total-1));
		}
	}
	/*3.(Display four patterns using loops) Use nested loops that display the following
	patterns in four separate programs:
	Pattern A        Pattern B  Pattern C    Pattern D
	1       	1 2 3 4 5 6       1 	1 2 3 4 5 6
	1 2     	1 2 3 4 5       2 1   	  1 2 3 4 5
	1 2 3   	1 2 3 4       3 2 1         1 2 3 4
	1 2 3 4 	1 2 3       4 3 2 1           1 2 3
	1 2 3 4 5 	1 2 	  5 4 3 2 1 	    	1 2
	1 2 3 4 5 6 1 	    6 5 4 3 2 1 	          1*/
	public static void printA() {
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= i; j ++) {
				print(j+" ");
			}
			print("\n");
		}
	}
	public static void printB() {
		for(int i = 6; i >= 0; i --) {
			for(int j = 1; j <= i; j ++) {
				print(j + " ");
			}
			print("\n");
		}
	}
	public static void printC() {
		int index = 0;
		for(int i = 1; i <= 6; i ++) {
			for(int j = 1; j <= 6-i; j ++) {
				print("  ");
			}
			for(int k = i; k >= 1; k--) {
				print(k + " ");
			}
			print("\n");
		}
	}
	public static void printD() {
		for(int i = 6; i >=0; i --) {
			for(int k = 1; k <= 6-i; k ++) {
				print("  ");
			}
			for(int j = 1; j <= i; j ++) {
				print(j + " ");
			}
			print("\n");
		}
	}
	
}
