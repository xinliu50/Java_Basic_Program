package practice;

public class Recursion {
	public static void main(String[]args) {
//		print(tribonacci(4));
//		print(tribonacciDynamic(4));
//		print(tribonacciTrace(4));
		var t1 = new TreeNode(4);
		var t2 = new TreeNode(2);
		var t3 = new TreeNode(6);
		var t4 = new TreeNode(1);
		var t5 = new TreeNode(3);
		
		t1.left = t2;
		t1.right = t3;	
		t2.left = t4;
		t2.right = t5;
		t1.print(t1);
		print(minDiffInBST(t1));
	}
	public static void print(Object o) {
		System.out.println(o);
	}
	/*
	 * The Tribonacci sequence Tn is defined as follows: 

	T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

	Given n, return the value of Tn.*/
	public static int tribonacci(int n) {
        if(n == 0)
        	return 0;
        if(n == 1)
        	return 1;
        if(n == 2)
        	return 1;
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
	//dynamic program
	public static int tribonacciDynamic(int n) {
		 if(n == 0)
	        return 0;
	     if(n ==1)
	        return 1;
	     if(n == 2)
	        return 1;
	     int[] arr = new int[n+1];
	     arr[0] = 0;
	     arr[1] = 1;
		 arr[2] = 1;
			
		 for(int i = 3; i <= n; i ++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		 }
		 return arr[n];			
	}
	public static int tribonacciTrace(int n) {
		if(n == 0)
	        return 0;
	    if(n == 1)
	        return 1;
	    if(n == 2)
	        return 1;
	    int a = 0;
	    int b = 1;
	    int c = 1;
	    int d;
	    for(int i = 3; i <= n; i ++) {
	    	d = a + b + c;
	    	a = b;
	    	b = c;
	    	c = d;
	    }
	    return c;
	}
	/*Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, 
also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.*/
    public static int minDiffInBST(TreeNode root) {
        return findMin(root, Integer.MAX_VALUE);
    }
    public static int findMin(TreeNode current, int min) {
    	//if it's empty tree, || reach to the leave
    	if(current == null || current.left == null && current.right == null)
    		return min;
    	if(current.left != null) 
    		if((current.val - current.left.val) < min)
    			return findMin(current.left, current.val - current.left.val);
    		else
    			return findMin(current.left, min);
    	
    	else
    		if((current.right.val - current.val) < min)
    			return findMin(current.right, current.right.val - current.val);
    		else
    			return findMin(current.right, min);
    	
    }

}
