package practice;
/*
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 */
import java.util.*;

public class SymmetricTree {
	public static void main(String []args) {
//		var t1 = new TreeNode(1);
//		var t2 = new TreeNode(2);
//		var t3 = new TreeNode(2);
//		var t4 = new TreeNode(3);
//		var t5 = new TreeNode(4);
//		var t6 = new TreeNode(4);
//		var t7 = new TreeNode(3);
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
//		t3.left = t6;
//		t3.right = t7;
//		
		var t1 = new TreeNode(1);
		var t2 = new TreeNode(2);
		var t3 = new TreeNode(2);
		var t4 = new TreeNode(3);
		var t5 = new TreeNode(3);
		
		t1.left = t2;
		t1.right = t3;
	
		t2.right = t4;
		
		t3.right = t5;
		
		print(t1);
		//print(isSymmetric(t1));
		print(isSymmetricLoop(t1));
		
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void print(TreeNode tree) {
		if(tree == null)
			return;
		print(tree.val + ": \n");
		if(tree.left != null)
			print( " left -> " + tree.left.val + "\n");
		if(tree.right != null)
			print( " right -> " + tree.right.val + "\n");
		print(tree.left);
		print(tree.right);
	}
	public static boolean isSymmetric(TreeNode root) {
		return is(root,root);
	}
	public static boolean is(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		return (left.val == right.val) && is(left.left,right.right) && is(left.right,right.left);
		
	}
	public static boolean isSymmetricLoop(TreeNode root) {
		var stack = new Stack<TreeNode>();
		var leftList = new ArrayList<Integer>();
		var rightList = new ArrayList<Integer>();;
		
		if(root.left == null && root.right == null)
			return true;
		if(root == null || root.left == null || root.right == null)
			return false;
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		stack.push(left);
		while(!stack.empty()) {
			var temp = stack.pop();
			leftList.add(temp.val);
			if(temp.left == null && temp.right == null) {
				continue;
			}else {
				if(temp.left != null) {
					stack.push(temp.left);
					leftList.add(temp.left.val);
				}else 
					leftList.add(null);
			
				if(temp.right != null) {
					stack.push(temp.right);
					leftList.add(temp.right.val);
				}else
					leftList.add(null);
			}
		}
		
		stack.push(right);
		while(!stack.empty()) {
			var temp = stack.pop();
			rightList.add(temp.val);
			if(temp.left == null && temp.right == null) {
				continue;
			}else {
				if(temp.right != null) {
					stack.push(temp.right);
					rightList.add(temp.right.val);
				}else 
					rightList.add(null);
			
				if(temp.left != null) {
					stack.push(temp.left);
					rightList.add(temp.left.val);
				}else
					rightList.add(null);
			}
		}
		
		var itLeft = leftList.iterator();
		var itRight = rightList.iterator();
		while(itLeft.hasNext() && itRight.hasNext()) {
			if(itLeft.next() != itRight.next())
				return false;
		}
		return true;
	}
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){ val = x; }
}
