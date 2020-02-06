package practice;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayLeetcode {
	
	public static void main(String []args) {
		var ls = new ArrayList<Integer>();
		ls.add(1);
		ls.add(9);
		ls.add(3);
		ls.add(2);
		System.out.println(ls);
		Integer[] intList = ls.toArray(new Integer[0]);
		int[] a = Arrays.stream(intList).mapToInt(i->i).toArray();
		int[] temp = new int[a.length];
		System.arraycopy(a, 0, temp, 0, a.length);
		print(a);
		System.out.println("");
		Arrays.sort(temp);
		print(a);
		
		print(temp);
		var map = new HashMap();
		
	}
	public static void print(int[]a) {
		for(int i = 0; i < a.length; i ++) 
			System.out.print(a[i] + ", ");
	}
	public static void print(Object o) {
		System.out.println(o);
	}
	
	/*char a = 97;
		int b = 90;
		System.out.println(a);
		System.out.println(b);
		//gave number, turn it to char
		int a1 = a-'a';
		System.out.println(a1);
		//[a,b,c,d,e,f,g,..];
		//[0,1,2,3,4,5...]
		char b1 = (char)b;
		char a2 = a;
		System.out.println(a2);
		//System.out.println(b1);*/
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
	   	
	/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 
	 * as one sorted array.

	Note:
	
	The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
	Example:
	
	Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	
	Output: [1,2,2,3,5,6]*/
	  	
	   	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        for(int i = 0; i < n; i ++) {
	        	nums1[i+m] = nums2[i];
	        }
	        Arrays.sort(nums1);
	    }
/*On a plane there are n points with integer coordinates points[i] = [xi, yi]. 
 * Your task is to find the minimum time in seconds to visit all points.
You can move according to the next rules:
In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
You have to visit the points in the same order as they appear in the array.

Example 1:
Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds
Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5
Constraints: 

points.length == n
1 <= n <= 100
points[i].length == 2
-1000 <= points[i][0], points[i][1] <= 1000*/
	   	
	   	public static int minTimeToVisitAllPoints(int[][] points) {
	        int[] disX = new int[points.length-1];
	        int[] disY = new int[points.length-1];
	        for(int i = 1; i < points.length; i++) {
	        	disX[i-1] = Math.abs(points[i-1][0]-points[i][0]);
	        	disY[i-1] = Math.abs(points[i-1][1]-points[i][1]);
	        }
	        int distance = 0;
	        for(int i = 0; i < disX.length; i ++) {
	        	distance += Math.max(disX[i],disY[i]);
	        }
	        return distance;
	    }
	   	/*Given an array of size n, find the majority element. The majority element is 
	   	 * the element that appears more than ⌊ n/2 ⌋ times.
		You may assume that the array is non-empty and the majority element always exist in the array
		Example 1:
		
		Input: [3,2,3]
		Output: 3
		Example 2:
		
		Input: [2,2,1,1,1,2,2]
		Output: 2*/
	   	public static int majorityElement(int[] nums) {
	        var map = new HashMap<Integer,Integer>();
	        for(int i : nums) {
	        	if(map.containsKey(i)) {
	        		map.put(i, map.get(i)+1);
	        	}else {
	        		map.put(i, 1);
	        	}
	        }
	        
	        var list = new ArrayList<Integer>();
	        for(int i : map.values()) {
	        	list.add(i);
	        }
	        Collections.sort(list);
	        int max = list.get(list.size()-1);
	        for(int i : map.keySet()) {
	        	if(map.get(i) == max)
	        		return i;
	        }
	        return -1;
	    }
	   	public static int majorityElementLoop(int[] nums) {
	   		int max = nums.length/2;
	   		for(int i : nums) {
	   			int count = 0;
	   			for(int num : nums) {
	   				if( i == num ) {
	   					count ++;
	   				}
	   				if(count > max)
	   					return i;
	   			}
	   		}
	   		return -1;
	   	}
	   	public static int majorityElementSort(int[] nums) {
	   		Arrays.sort(nums);
	   		return nums[nums.length/2];
	   	}
	   	/*The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
	   	 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
		F(0) = 0,   F(1) = 1
		F(N) = F(N - 1) + F(N - 2), for N > 1.
		Given N, calculate F(N).	
		Example 1:		
		Input: 2
		Output: 1
		Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
		Example 2:	
		Input: 3
		Output: 2
		Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
		Example 3:
		
		Input: 4
		Output: 3
		Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.	
		Note:	
		0 ≤ N ≤ 30.* */
	    public static int fib(int n) {
	        if(n == 0)
	        	return 0;
	        if(n == 1)
	        	return 1;
	        return fib(n-1) + fib(n-2);
	    }
	    public static int fibLoop(int N) {
	    	if(N == 0)
	    		return 0;
	    	if(N == 1)
	    		return 1;
	        int[] a = new int[N+1];
	        a[0] = 0;
	        a[1] = 1;
	        for(int i = 2; i <= N; i ++) {
	        	a[i] = a[i-1]+a[i-2];
	        }
	        return a[N];
	    }
	    public static int fibNum(int N) {
	    	if(N == 0)
	    		return 0;
	    	if(N == 1)
	    		return 1;
	    	int a = 0;
	    	int b = 1;
	    	int c;
	    	
	    	for(int i = 2; i <= N; i ++) {
	    		c = a + b;
	    		a = b;
	    		b = c;
	    	}
	    	return b;
	    }
	    /*Given a date, return the corresponding day of the week for that date.
		The input is given as three integers representing the day, month and year respectively.
		
		Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", 
		"Thursday", "Friday", "Saturday"}.
	
		Example 1:
		Input: day = 31, month = 8, year = 2019
		Output: "Saturday"
		Example 2:
		
		Input: day = 18, month = 7, year = 1999
		Output: "Sunday"
		Example 3:
		
		Input: day = 15, month = 8, year = 1993
		Output: "Sunday"
		
		Constraints:
		
		The given dates are valid dates between the years 1971 and 2100.*/
	    public static String dayOfTheWeek(int day, int month, int year) {
	    	Calendar d = new GregorianCalendar(year,month-1,day,13,24,56);
	        int c = d.get(Calendar.DAY_OF_WEEK);
	        if(c == 1)
	        	return "Sunday";
	        if(c == 2) {
	        	return "Monday";
	        }
	        if(c == 3)
	        	return "Tuesday";
	        if(c == 4)
	        	return "Wednesday";
	        if(c == 5)
	        	return "Thursday";
	        if(c == 6)
	        	return "Friday";
	        
	        return "Saturday";	        
	    }
	    /*A matrix is Toeplitz if every diagonal from top-left to bottom-right has 
	     * the same element.
	Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
		Example 1:
		
		Input:
		matrix = [
		  [1,2,3,4],
		  [5,1,2,3],
		  [9,5,1,2]
		]
		Output: True
		Explanation:
		In the above grid, the diagonals are:
		"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
		In each diagonal all elements are the same, so the answer is True.
		Example 2:
		
		Input:
		matrix = [
		  [1,2],
		  [2,2]
		]
		Output: False
		Explanation:
		The diagonal "[1, 2]" has different elements.
		
		Note:
		
		matrix will be a 2D array of integers.
		matrix will have a number of rows and columns in range [1, 20].
		matrix[i][j] will be integers in range [0, 99].*/
	    public static boolean isToeplitzMatrix(int[][] matrix) {
	        for(int i = 0; i < matrix.length; i ++) {
	        	for(int j = 0; j < matrix[0].length; j++) {
	        		int i1 = i;
        			int j1 = j;
	        		while(i1-1 >= 0 && j1-1 >= 0){
	        			if(matrix[i][j] != matrix[i1-1][j1-1])
	        				return false;
	        			i1--;
	        			j1--;
	        		}
	        		i1 = i;
	        		j1 = j;
	        		while(i1+1 < matrix.length && j1+1 < matrix[0].length){
	        			if(matrix[i][j] != matrix[i1+1][j1+1])
	        				return false;
	        			i1++;
	        			j1++;
	        		}
	        	}
	        }
	        return true;
	    }
	    
	    public static boolean isToeplitzMatrixCompareToBelowRight(int[][] matrix) {
	        for(int i = 0; i < matrix.length; i ++){
	            for(int j = 0; j < matrix[0].length; j++){
	                if(i+1 < matrix.length && j+1 <matrix[0].length){
	                   if(matrix[i][j] != matrix[i+1][j+1])
	                    {
	                       return false;
	                   }
	                }
	            }
	        }
	                return true;
	    }
	   /*Given an array A of integers, return true if and only if we can partition 
	    * the array into three non-empty parts with equal sums.
	Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + 
	... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
	Example 1:
	Input: [0,2,1,-6,6,-7,9,1,2,0,1]
	Output: true
	Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
	Example 2:
	
	Input: [0,2,1,-6,6,7,9,-1,2,0,1]
	Output: false
	Example 3:
	
	Input: [3,3,6,5,-2,2,5,1,-9,4]
	Output: true
	Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
	 
	
	Note:
	
	3 <= A.length <= 50000
	-10000 <= A[i] <= 10000*/
	    
	    public static boolean canThreePartsEqualSum(int[] A) {
	        int count = 0;
	        int total = 0;
	        for(int i : A){
	            total += i;
	        }
	        if(total % 3 != 0)
	            return false;
	        int sum = total/3;
	        int index = 0;
	        w:while(index < A.length){
	            int temp = A[index];
	            while(temp != sum){
	                temp += A[++index];
	                if(index >= A.length-1)
	                    break w;
	            }
	            count ++;
	            index ++;
	        }  
	        return count == 3;
	    }
	    public static boolean canThreePartsEqualSumOneLoop(int[] A) {
	        int count = 0;
	        int total = 0;
	        for(int i : A){
	            total += i;
	        }
	        if(total % 3 != 0)
	            return false;
	        int sum = total/3;
	        
	        return count == 3;
	    }
	    
	    public static List<String> commonChars(String[] A) {
	    	int[] before = new int[26];
        	for(int j = 0; j < A[0].length(); j ++) {
        		before[A[0].charAt(j)-'a'] += 1;
        	}
	    	
	        for(int i = 1; i < A.length; i++) {
	        	int[] after = new int[26];
	        	for(int j = 0; j < A[i].length(); j++) {
	        		after[A[i].charAt(j)-'a'] += 1;
	        	}
	        	int[] result = new int[26];
	        	for(int k = 0; k < 26; k ++) {
	        		result[k] = Math.min(before[k], after[k]);
	        	}
	        	before = result;
	        }
	        var ls = new ArrayList<String>();
	        for(int i = 0; i < 26; i ++) {
	        	for(int j = 0; j < before[i]; j ++) {
	        		ls.add((char)(i+'a')+"");	
	        	}
	        }
	        return ls;
	    }
	    
	    public static List<String> commonCharsOpmize(String[] A) {    	
	    	int[] before = new int[26];
	    	Arrays.fill(before, Integer.MAX_VALUE);
	    
	    	for(int i = 0; i < A.length; i ++) {
	    		int []after = new int[26];
	    		for(int j = 0; j < A[i].length(); j ++) {
	    			if(before[A[i].charAt(j)-'a'] != 0) {
	    				after[A[i].charAt(j)-'a'] += 1;
	    			}
	    		}
	    		for(int j = 0; j < 26; j ++) {
	    			before[j] = Math.min(before[j], after[j]);
	    		}
	    	}
	    	
	    	var list = new ArrayList<String>();
	    	for(int i = 0; i < 26; i ++) {
	    		for(int j = 0; j < before[i]; j ++) {
	    			list.add((char)(i+'a')+"");
	    		}
	    	}
	    	return list;
	    }
	    /*We have an array A of integers, and an array queries of queries.
	For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  
	Then, the answer to the i-th query is the sum of the even values of A.
	(Here, the given index = queries[i][1] is a 0-based index, and each query permanently
	modifies the array A.)
	Return the answer to all queries.  Your answer array should have answer[i] as the answer 
	to the i-th query.
	Example 1:
	
	Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
	Output: [8,6,2,4]
	Explanation: 
	At the beginning, the array is [1,2,3,4].
	After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
	After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
	After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
	After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
	Note:
	
	1 <= A.length <= 10000
	-10000 <= A[i] <= 10000
	1 <= queries.length <= 10000
	-10000 <= queries[i][0] <= 10000
	0 <= queries[i][1] < A.length*/
	    
	    //reach to time limit
	    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
	    	int []result = new int[queries.length];
	    	for(int i = 0; i < queries.length; i ++){
	    		A[queries[i][1]] += queries[i][0];
	    		int total = 0;
	    		for(int j = 0; j < A.length; j ++){
	    			if(A[j] % 2 == 0){
	    				total += A[j];
	    			}
	    		}
	    		result[i] = total;
	    	}
	    	return result;
	    }
	    //remember even total of A all the time
	    public static int[] sumEvenAfterQueriesOptimize(int[] A, int[][] queries) {
	        int even = 0;
	        for(int i = 0; i < A.length; i ++){
	             if(A[i] % 2 == 0){
	                    even += A[i];
	              }
	        }
	        int []result = new int[queries.length];
	        for(int i = 0; i < queries.length; i ++){
	            int before = A[queries[i][1]];
	            A[queries[i][1]] += queries[i][0];     
	            if(before%2 == 0 && A[queries[i][1]]%2 != 0){
	                even -= before;
	            }else if(before%2 == 0){
	                 even -= before;
	                 even += A[queries[i][1]];
	            }else if(before%2 != 0 && A[queries[i][1]]%2 == 0){
	                even += A[queries[i][1]];
	            }
	            result[i] = even;
	        }
	        return result;
	    }
	    /*Given a 2D grid of size m x n and an integer k. You need to shift the 
		 * grid k times.
	In one shift operation:
	Element at grid[i][j] moves to grid[i][j + 1].
	Element at grid[i][n - 1] moves to grid[i + 1][0].
	Element at grid[m - 1][n - 1] moves to grid[0][0].
	Return the 2D grid after applying shift operation k times.
	Example 1:
		
	Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
	Output: [[9,1,2],[3,4,5],[6,7,8]]
	Example 2:
	Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
	Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
	Example 3:
	
	Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
	Output: [[1,2,3],[4,5,6],[7,8,9]]*/
	    
	    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][]result = new int[m][n];
	        for(int i = 0; i < m; i ++){
	            for(int j = 0; j < n; j ++){
	            	if((j+k) > n-1) {
	            		result[(i+(j+k)/n)%m][(j+k)%n] = grid[i][j];
	            	}
	            	else {
	            		result[i][j+k] = grid[i][j];
	            	}
	           
	            }
	        }
	        var ls = new ArrayList<List<Integer>>();
	         for(int i = 0; i < m; i ++){
	             var temp = new ArrayList<Integer>();
	            for(int j = 0; j < n; j ++){
	                temp.add(result[i][j]);
	            }
	            ls.add(temp);
	        }
	        return ls;
	    }
	    public static List<List<Integer>> shiftGridInPlace(int[][] grid, int k) {
	       int prev = grid[grid.length-1][grid[0].length];
	       for(int i = 0; i < grid.length; i ++) {
	    	   for(int j = 0; j < grid[0].length; j ++) {
	    		   int temp = grid[i][j];
	    		   grid[i][j] = prev;
	    		   prev = temp;
	    	   }
	       }
	       var ls = new ArrayList<List<Integer>>();
	       for(int []r : grid) {
	    	   var temp = new ArrayList<Integer>();
	    	   ls.add(temp);
	    	   for(int num : r)
	    		   temp.add(num);
	       }
	       return ls;
	    }
	    /*Given an integer array nums, find the contiguous subarray (containing at 
	     * least one number) which has the largest sum and return its sum.
		Example:
		
		Input: [-2,1,-3,4,-1,2,1,-5,4],
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.*/
	    public static int maxSubArray(int[] nums) {
	        int max_current = nums[0];
	        int max_so_far = nums[0];
	        for(int i = 1; i < nums.length; i ++) {
	        	max_current = Math.max(nums[i], nums[i]+ max_current);
	        	max_so_far = Math.max(max_current, max_so_far);
	        }
	        return max_so_far;
	    }
	    public static int[] maxSubArrayReturnSub(int[] nums){
	    	int current = nums[0];
	    	int soFar = nums[0];
	    	int left = 0;
	    	int right = 0;
	    	for(int i = 1; i < nums.length; i ++) {
	    		if(current+nums[i] > nums[i]) {
	    			current = current+nums[i];
	    		}else {
	    			left = i;
	    			current = nums[i];
	    		}
	    		if(current > soFar) {
	    			right = i;
	    			soFar = current;
	    		}
	    	}
	    	int[] re = new int[right-left+1];
	    	for(int i = left; i <= right; i ++) {
	    		re[i-left] = nums[i];
	    	}
	    	return re;
	    }
/*Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] 
 * if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be 
 * rotated to be equal to another domino.
Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] 
is equivalent to dominoes[j].
Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
 

Constraints:

1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9*/
	    public static int numEquivDominoPairs(int[][] dominoes) {
	        if(dominoes.length == 1)
	            return 0;
	        int total = 0;
	        for(int i = 0; i < dominoes.length; i ++){
	         for(int j = i+1; j < dominoes.length; j ++){
	if(dominoes[i][0]* dominoes[i][1] == dominoes[j][0]* dominoes[j][1] &&
	  dominoes[i][0]+ dominoes[i][1] == dominoes[j][0]+ dominoes[j][1])
	            total += 1;
	         }
	        }
	        return total;
	    }
	    
/*In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is 
divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 
Note:

1 <= time.length <= 60000
1 <= time[i] <= 500*/
	    //bruce force reach to time limit 
	    public static int numPairsDivisibleBy60(int[] time) {
	    	int total = 0;
	    	for(int i = 0; i < time.length; i ++) {
	    		for(int j = i+1; j < time.length; j ++) {
	    			if((time[i] + time[j])%60 == 0)
	    				total += 1;
	    		}
	    	}
	    	return total;
	    }
	    //remember mol
	    public static int numPairsDivisibleBy60Mol(int[] time) {
	    	int[] mol = new int[60];
	    	for(int i = 0; i < time.length; i ++) {
	    		mol[time[i]%60] += 1;
	    	}
	    	int total = 0;
	    	if(mol[30] != 0)
	    		total += (mol[30] * (mol[30]-1))/2;
	    	if(mol[0] != 0)
	    		total += (mol[0] * (mol[0]-1))/2;
	    	
	    	for(int i = 1; i < 30; i ++) {
	    		if(mol[i] != 0 && mol[60-i] != 0)
	    			total += mol[i]*mol[60-i];
	    	}
	    	return total;
	    }
	    /*Given a sorted array nums, remove the duplicates in-place such that each element appear 
	     * only once and return the new length.
		Do not allocate extra space for another array, you must do this by modifying the input array 
		in-place with O(1) extra memory.
		Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3,
and 4 respectively.
It doesn't matter what values are set beyond the returned length.

Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means modification to the input array will be 
known to the caller as well.

Internally you can think of this:
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}*/
	    public static int removeDuplicates(int[] nums) {
	        if(nums.length == 0)
	            return 0;         
	        int i = 0;
	        for(int j = 1; j < nums.length; j ++){
	            if(nums[i] != nums[j]){
	                nums[i+1] = nums[j];
	                i++;
	            }
	        }
	        return i+1;
	    }
	   /*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
	Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach 
	the top of the floor, and you can either start from the step with index 0, or the step with index 1.
	
	Example 1:
	Input: cost = [10, 15, 20]
	Output: 15
	Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
	Example 2:
	Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
	Output: 6
	Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
	Note:
	cost will have a length in the range [2, 1000].
	Every cost[i] will be an integer in the range [0, 999].
	    * */ 
	    public static int minCostClimbingStairs(int[] cost) {
	        int f1 = 0, f2 = 0;
	        for(int i = cost.length-1; i >= 0; i --){
	            int f0 = cost[i] + Math.min(f1,f2);
	            f2 = f1;
	            f1 = f0;
	        }
	        return Math.min(f1,f2);
	    }
	    //forward 
	    public static int minCostClimbingStairsForward(int[] cost) {
	        int f1 = 0, f2 = 0;
	        for(int i = 0; i < cost.length; i ++){
	            int f0 = cost[i] + Math.min(f1,f2);
	            f2 = f1;
	            f1 = f0;
	        }
	        return Math.min(f1,f2);
	    }
	    //remember cost in place
	    public int minCostClimbingStairsInPlace(int[] cost) {
	        for(int i = 2; i < cost.length; i ++){
	            cost[i] += Math.min(cost[i-1],cost[i-2]);
	        }
	         return Math.min(cost[cost.length-1],cost[cost.length-2]);
	     }
	    
	    /*Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), 
	     * return the indexes of the k weakest rows in the matrix ordered from the weakest to the 
	     * strongest.
A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers 
in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in 
the frontier of a row, that is, always ones may appear first and then zeros.
Example 1:
Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4]
Example 2:
Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 1 
row 1 -> 4 
row 2 -> 1 
row 3 -> 1 
Rows ordered from the weakest to the strongest are [0,2,3,1]
Constraints:

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.*/
	    public static int[] kWeakestRows(int[][] mat, int k) {
	        int[] arry = new int[k];
	        int index = 0;
	        boolean []visit = new boolean[mat.length];
	        boolean flag = false;
	        for(int i = 0; i < mat[0].length; i ++){
	            for(int j = 0; j < mat.length; j ++){
	                if(!visit[j] && index < k && mat[j][i] == 0){
	                    arry[index] = j;
	                    visit[j] = true;
	                    index ++;
	                }else if(index >= k){
	                    flag = true;
	                    break;
	                }
	            }
	        }
	        if(!flag){
	            for(int i = 0; i < visit.length; i ++){
	                if(index <= arry.length-1 && !visit[i]){
	                    arry[index] = i;
	                    visit[i] = true;
	                    index ++;
	                }
	            }
	        }
	        return arry;
	    }
	    /*Given an array of distinct integers arr, find all pairs of elements with the minimum 
	     * absolute difference of any two elements. 
		Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
		a, b are from arr
		a < b
		b - a equals to the minimum absolute difference of any two elements in arr
		Example 1:		
		Input: arr = [4,2,1,3]
		Output: [[1,2],[2,3],[3,4]]
		Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 
		in ascending order.
		Example 2:
		Input: arr = [1,3,6,10,15]
		Output: [[1,3]]
		Example 3:		
		Input: arr = [3,8,-10,23,19,-4,-14,27]
		Output: [[-14,-10],[19,23],[23,27]]		
		Constraints:	
		2 <= arr.length <= 10^5
		-10^6 <= arr[i] <= 10^6*/
	    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
	        var ls = new ArrayList<List<Integer>>();
	        Arrays.sort(arr);
	        int prev = arr[0];
	        int min = Integer.MAX_VALUE;
	        for(int i = 1; i < arr.length; i ++){
	            min = Math.min(min,arr[i]-prev);
	            if(min == 1)
	                break;
	            prev = arr[i];
	        }
	        var set = new HashSet<Integer>();
	        for(int i = 0; i < arr.length; i ++){
	        	set.contains(arr[i]);
	        }
	        for(int i = 0; i < arr.length; i ++){
	            if(set.contains(arr[i]+min)){
	                var temp = new ArrayList<Integer>();
	                temp.add(arr[i]);
	                temp.add(arr[i]+min);
	                ls.add(temp);
	            }
	        }
	        return ls;
	    }
	    /*Given an array arr, replace every element in that array with the greatest element 
	     * among the elements to its right, and replace the last element with -1.
		 * After doing so, return the array.
	     */
	    public static int[] replaceElements(int[] arr) {
	        int[] result = new int[arr.length];
	        for(int i = 0; i <= arr.length-2; i ++){
	            int max = Integer.MIN_VALUE;
	            for(int j = i+1; j < arr.length; j ++){
	                max = Math.max(arr[j],max);
	            }
	            result[i] = max;
	        }
	        result[result.length-1] = -1;
	        return result;
	    }
	    
	    /*Given a non-empty array of digits representing a non-negative integer, 
	     * plus one to the integer.
		The digits are stored such that the most significant digit is at the head of the list, 
		and each element in the array contain a single digit.
		You may assume the integer does not contain any leading zero, except the number 0 itself.
		
		Example 1:
		
		Input: [1,2,3]
		Output: [1,2,4]
		Explanation: The array represents the integer 123.
		Example 2:
		
		Input: [4,3,2,1]
		Output: [4,3,2,2]
		Explanation: The array represents the integer 4321.*/
	    
	    public static int[] plusOne(int[] digits) {
	        var ls = new ArrayList<Integer>();
	        int c = 1;
	        for(int i = digits.length-1; i >= 0; i --){
	            if(digits[i]+c >= 10){
	                ls.add(digits[i]+c-10);
	                c = 1;
	            }else{
	                ls.add(digits[i]+c);
	                c = 0;
	            }
	        }
	        if(c == 1){
	            ls.add(1);
	        }
	    
	        Collections.reverse(ls);
	        Integer[] a = ls.toArray(new Integer[0]);
	        int[] result = Arrays.stream(a).mapToInt(i->i).toArray();
	        return result;
	    }
	    /*Given an array of integers arr, replace each element with its rank.
		The rank represents how large the element is. The rank has the following rules:
		Rank is an integer starting from 1.
		The larger the element, the larger the rank. If two elements are equal, their rank 
		must be the same.
		Rank should be as small as possible.
		Example 1:
		Input: arr = [40,10,20,30]
		Output: [4,1,2,3]
		Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 
		30 is the third smallest.
		Example 2:
		Input: arr = [100,100,100]
		Output: [1,1,1]
		Explanation: Same elements share the same rank.
		Example 3:
		Input: arr = [37,12,28,9,100,56,80,5,12]
		Output: [5,3,4,2,8,6,7,1,3]
		 
		
		Constraints:
		
		0 <= arr.length <= 105
		-109 <= arr[i] <= 109*/
	    public static int[] arrayRankTransform(int[] arr) {
	        int[] temp = new int[arr.length];
	        Arrays.sort(temp);
	        var map = new HashMap<Integer,Integer>();
	        int index = 1;
	        for(int i = 0 ; i < temp.length; i ++){
	            if(map.containsKey(temp[i])){
	                 map.put(temp[i],--index);     
	            }else{
	                 map.put(temp[i],index);     
	            } 
	            index ++;
	        }
	        int[] result = new int[arr.length];
	        for(int i = 0; i < arr.length; i ++){
	            result[i] = map.get(arr[i]);
	        }
	        return result;
	    }
}

