package practice;
/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/
public class PathSum {
	public static void main(String[]args) {
		var t1 = new TreeNode(5);
		var t2 = new TreeNode(4);
		var t3 = new TreeNode(8);
		var t4 = new TreeNode(11);
		var t5 = new TreeNode(13);
		var t6 = new TreeNode(4);
		var t7 = new TreeNode(7);
		var t8 = new TreeNode(2);
		var t9 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t4.left = t7;
		t4.right = t8;
		t6.right = t9;
		print(t1);
		print("\n");
		print(hasPathSum(t1,22));
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
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null && sum-root.val == 0)
			return true;
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}

}
