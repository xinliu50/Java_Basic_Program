package practice;

import java.util.LinkedList;

/*Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false*/
public class SameTree {
	public static void main(String []args) {
		var t1 = new TreeNode(1);
		var t2 = new TreeNode(2);
		var t3 = new TreeNode(2);
		var t4 = new TreeNode(3);
		var t5 = new TreeNode(3);
		
		t1.left = t2;
		t1.right = t3;	
		t2.right = t4;
		t3.right = t5;	
		
		var temp = t1;
		
		//print(sameTree(t1,temp));
		print(isSameTree(t1,temp));

		
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void print(TreeNode root){
		if(root == null)
			return;
		print(root.val + ": " + "\n");
		if(root.left != null) 
			print(" left: " + root.left.val + " \n");
		if(root.right != null)
			print(" right: " + root.right.val + " \n");
		print(root.left);
		print(root.right);
	}
	public static boolean sameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		return (p.val == q.val) && sameTree(p.left,q.left) && sameTree(p.right,q.right);
	}
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		var ls = new LinkedList<TreeNode>();
		ls.add(p);
		ls.add(q);
		while(!ls.isEmpty()) {
			var p1 = ls.poll();
			var p2 = ls.poll();
			if(p1 == null && p2 == null)
				continue;
			if(p1 == null || p2 == null)
				return false;
			if(p1.val != p2.val)
				return false;
			ls.add(p1.left);
			ls.add(p2.left);
			ls.add(p1.right);
			ls.add(p2.right);
		}
		return true;
	}
}
