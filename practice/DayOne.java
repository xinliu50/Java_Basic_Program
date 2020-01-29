package practice;

public class DayOne {
	public static void main(String []args) {
		displayPopulation();
		printProgram();
		forLoop();
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	
	/*
	 *  (Population projection) The U.S. Census Bureau projects population based on the
	following assumptions:
	¶ One birth every 7 seconds
	¶ One death every 13 seconds
	¶ One new immigrant every 45 seconds
	Write a program to display the population for each of the next five years. Assume
	the current population is 312,032,486 and one year has 365 days. Hint: In Java, if
	two integers perform division, the result is an integer. The fraction part is truncated.
	For example, 5 / 4 is 1 (not 1.25) and 10 / 4 is 2 (not 2.5).*/
	public static void displayPopulation() {
		int current = 312032486;
		for(int i = 1; i <= 5; i ++) {
			int birth = 60*60*24*365*i/7;
			int death = 60*60*24*365*i/13;
			int immigrant = 60*60*24*365*i/45;
			println(current+birth+immigrant-death);
		}
	}
	/*
	 * write a java program to display the following series
	    *
	   * *
	  * * *
	 * * * *
	* * * * **/
	public static void printProgram() {
		 println("    *");
		 println("   * *");  
		 println("  * * *"); 
		 println(" * * * *");
		 println("* * * * *");	
	}
	/* Write a Java program by using three for loops to print the following pattern:
	 * 1******
	12*****	
	123****	
	1234***	
	12345**	
	123456*	
	1234567*/
	public static void forLoop() {
		int index = 0;
		for(int i = 1; i <= 7; i ++) {
			for(int j = 1; j <= i; j ++) {
				print(j);
				index = j;
			}
			for(int k = index; k <= 7; k ++) {
				print("*");
			}
			print("\n");
		}
	}
		
}
