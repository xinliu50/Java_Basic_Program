package practice;
/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/
public class MoveZeroes {
	public static void main(String []args) {
		int[] input = {0,1,0,3,12};
		moveZeros(input);
		print(input);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void print(int[] a) {
		print("[");
		for(int i = 0; i < a.length; i ++) {
			print(a[i] + ",");
		}
		print("]");

	}
	public static void moveZeros(int[] input) {
		for(int i = 0; i < input.length; i ++) {
			if(input[i] == 0) {
				for(int j = i; j < input.length; j ++) {
					if(input[j] != 0) {
						input[i] = input[j];
						input[j] = 0;
						break;
					}
				}
			}
		}
	}
}
