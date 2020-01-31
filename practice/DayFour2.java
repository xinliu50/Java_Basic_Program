package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/*Write a program that reads an unspecified number of integers and finds the one that 
 * has the most occurrences. The input ends when the input is 0. For example, if you entered 
 * 2 3 40 3 5 4 –3 3 3 2 0, the number 3 occurred most often. If not one but several numbers have the 
 * most occurrences, all of them should be reported. For example, since 9 and 3 appear twice in the list 
 * 9 30 3 9 3 2 4, both occurrences should be reported.*/
public class DayFour2 {
	public static void main(String[]args) {
		System.out.println(findMost());
	}
	public static ArrayList<Integer> findMost(){
		Scanner sc = new Scanner(System.in);
		var map = new HashMap<Integer,Integer>();
		
		System.out.println("Enter your number");
		int n = sc.nextInt();
		while(n != 0) {
			if(map.containsKey(n)) {
				map.put(n, map.get(n)+1);
			}else {
				map.put(n, 1);
			}
			n = sc.nextInt();
		}
		var list = new ArrayList<Integer>();
		for(int i : map.values()) {
			list.add(i);
		}
		Collections.sort(list,Collections.reverseOrder());
		int max = list.get(0);
		var result = new ArrayList<Integer>();
		for(int i : map.keySet()) {
			if(map.get(i) == max)
				result.add(i);
		}
		return result;
	}
}
