package practice;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayLeetcode {
	public static void main(String []args) {
//		int []a = {2,3,1,3,2,4,6,7,9,2,19};
//		int []b = {2,1,4,3,9,6};
//		print(relativeSortArray(a,b));
//		int []a = {9,6,4,2,3,5,7,0,1};
//		print(missingNumber(a));
//		print(missingNumberXOR(a));
		int[] a = {2,2,2,2};
		print(isMonotonic(a));
		int birth = 7*60*60*24*365;
		int death = 13*60*60*24*365;
		int immigrant = 45*60*60*24*365;
		print(birth);
		print(death);
		print(immigrant);
	}
	public static void print(Object o) {
		System.out.println(o);
	}
	public static void print(int[] a) {
		print("[");
		for(int i : a)
			print(i + ", ");
		print("]\n");
	}
	/*Given an array A of integers, return true if and only if it is a valid mountain array.

	Recall that A is a mountain array if and only if:
	
	A.length >= 3
	There exists some i with 0 < i < A.length - 1 such that:
	A[0] < A[1] < ... A[i-1] < A[i]
	A[i] > A[i+1] > ... > A[A.length - 1]
	Example 1:

	Input: [2,1]
	Output: false
	Example 2:
	
	Input: [3,5,5]
	Output: false
	Example 3:
	
	Input: [0,3,2,1]
	Output: true*/
	public static boolean validMountainArray(int[] A) {
		if(A.length < 3)
			return false;
		int min = A[0];
		int index = -1;
        for(int i = 1; i < A.length; i ++) {
        	if(min >= A[i]) {
        		index = i-1;
        		break;
        	}
        	min = A[i];
        }
        min = A[A.length-1];
        for(int i = A.length-2; i >= 0; i --) {
        	if(A[i] <= min) {
        		return (index == i+1);
        	}
        	min = A[i];
        }
        return false;
    }
	public static boolean validMountainArrayWalk(int[] A) {
		if(A.length < 3)
			return false;
		int i = 0;
		int N = A.length;
		
		while(i < N-1 && A[i] < A[i+1])
			i ++;
		if(i == N-1 || i == 0)
			return false;
		while(i < N-1 && A[i] > A[i+1])
			i ++;
		return i == N-1;
	}
	/*Given an array of integers that is already sorted in ascending order, 
	 * find two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they add up 
	to the target, where index1 must be less than index2.
	
	Note:
	
	Your returned answers (both index1 and index2) are not zero-based.
	You may assume that each input would have exactly one solution and you may not use 
	the same element twice.
	Example:
	
	Input: numbers = [2,7,11,15], target = 9
	Output: [1,2]
	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.*/
	public static int[] twoSum(int[] numbers, int target) {
		if(numbers.length < 2)
			throw new IllegalArgumentException("illegal argument");
		for(int i = 0; i < numbers.length; i ++) {
			if(target - numbers[i] < numbers[i])
				return null;
			for(int j = i+1; j < numbers.length; j ++) {
				if(numbers[i] + numbers[j] == target)
					return new int[] {i+1, j+1};
			}
		}
		return null;
	}
	/*Given a matrix A, return the transpose of A.

	The transpose of a matrix is the matrix flipped over it's main diagonal, 
	switching the row and column indices of the matrix.
	Example 1:

	Input: [[1,2,3],[4,5,6],[7,8,9]]
	Output: [[1,4,7],[2,5,8],[3,6,9]]
	Example 2:
	
	Input: [[1,2,3],[4,5,6]]
	Output: [[1,4],[2,5],[3,6]]*/
	
	public static int[][] transpose(int[][] A){
		int[][] arr = new int[A[0].length][A.length];
		for(int i = 0; i < A.length; i ++) {
			for(int j = 0; j < A[0].length; j ++) {
				arr[j][i] = A[i][j];
			}
		}
		return arr;
	}
	
	/*Given two arrays arr1 and arr2, the elements of arr2 are distinct, 
	 * and all elements in arr2 are also in arr1.

	Sort the elements of arr1 such that the relative ordering of items in arr1 are 
	the same as in arr2.  Elements that don't appear in arr2 should be placed at the 
	end of arr1 in ascending order. 
	
	Example 1:
	
	Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
	Output: [2,2,2,1,4,3,3,9,6,7,19]
	 
	
	Constraints:
	
	arr1.length, arr2.length <= 1000
	0 <= arr1[i], arr2[i] <= 1000
	Each arr2[i] is distinct.
	Each arr2[i] is in arr1.*/
	
	 public static int[] relativeSortArray(int[] arr1, int[] arr2) {
	        int[] arr = new int [arr1.length];
	        int index = 0;
	        
	        for(int i = 0; i < arr2.length; i ++) {
	        	for(int j = 0; j < arr1.length; j ++) {
	        		if(arr2[i] == arr1[j]) {
	        			arr[index] = arr2[i];
	        			index ++;
	        		}
	        	}
	        }
	        int[] left = new int [arr1.length - index];
	        int leftIndex = 0;
	        boolean flag;
	        for(int i = 0; i < arr1.length; i ++) {
	        	flag = false;
	        	for(int j = 0; j < arr2.length; j ++) {
	        		if(arr1[i] == arr2[j])
	        			flag = true;
	        	}
	        	if(!flag) {
	        		left[leftIndex] = arr1[i];
	        		print("left" + leftIndex + ":" + left[leftIndex]+"\n");
	        		leftIndex ++;
	        	}
	        }
	        
	        //sort left[]
	        
	        for(int i = 0; i < left.length; i ++) {
	        	int min = left[i];
	        	int d = i;
	        	for(int j = i+1; j < left.length; j ++) {
	        		if(min > left[j]) {
	        			min = left[j];
	        			d = j;
	        		}
	        	}
	        	if(d != i) {
	        		left[d] = left[i];
	        		left[i] = min;
	        	}
	        }
	        print(left);
	        for(int i = index; i < arr1.length; i ++) {
	        	arr[i] = left[i - index];
	        }
	        return arr;
	 }
	 /*
	  * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
	  * find the one that is missing from the array.

		Example 1:
		
		Input: [3,0,1]
		Output: 2
		Example 2:
		
		Input: [9,6,4,2,3,5,7,0,1]
		Output: 8
	  * */
	 
	   //linear runtime complexity and constant space complexity
	   public static int missingNumber(int[] nums) {
		   Arrays.sort(nums);
		   if(nums[0] != 0)
			   return 0;
		   if(nums[nums.length-1] != nums.length)
			   return nums.length;
		   for(int i = 1; i < nums.length; i ++) {
			   int ex = nums[i-1];
			   if(nums[i] != ex+1)
				   return ex+1;
		   }
		   return -1;
	   }
	   
	   public static int missingNumberSet(int[] nums) {
		   var set = new HashSet<Integer>();
		   for(int i : nums) {
			   set.add(i);
		   }
		   for(int i = 0; i <= nums.length; i ++) {
			   if(!set.contains(i))
				   return i;
		   }
		   return -1;
	   }
	   //XOR
	   public static int missingNumberXOR(int[] nums) {
		   int missing = nums.length;
		   for(int i = 0; i < nums.length; i++) {
			   missing ^= i ^ nums[i];
		   }
		   return missing;
	   }
	   /*An array is monotonic if it is either monotone increasing or monotone decreasing.

		An array A is monotone increasing if for all i <= j, A[i] <= A[j].  
		An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
		
		Return true if and only if the given array A is monotonic.	
		Example 1:
		
		Input: [1,2,2,3]
		Output: true
		Example 2:
		
		Input: [6,5,4,4]
		Output: true
		Example 3:
		
		Input: [1,3,2]
		Output: false
		Example 4:
		
		Input: [1,2,4,5]
		Output: true
		Example 5:
		
		Input: [1,1,1]
		Output: true
		 
		
		Note:
		
		1 <= A.length <= 50000
		-100000 <= A[i] <= 100000*/
	   	public static boolean isMonotonic(int[] A) {
	   		if(A.length == 1)
	            return true;
	         boolean decFlag = false, incFlag = false, sameFlag = false;
		        for(int j = 1; j < A.length; j ++) {
		        	if(A[j] < A[j-1])
		        		decFlag = true;
		        	else if(A[j] > A[j-1])
		        		incFlag = true;
		        	else if(A[j] == A[j-1])
	                    sameFlag = true;
		        }
		     return (decFlag ^ incFlag) || sameFlag && !(decFlag && incFlag);
	    }
}
