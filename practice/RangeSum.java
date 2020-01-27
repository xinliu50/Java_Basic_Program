package practice;

import java.util.Stack;

/*Given the root node of a binary search tree, return the sum of values 
 * of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 */
public class RangeSum {
	public static void main(String []args) {
		var t1 = new TreeNode(10);
		var t2 = new TreeNode(5);
		var t3 = new TreeNode(15);
		var t4 = new TreeNode(3);
		var t5 = new TreeNode(7);
		var t6 = new TreeNode(18);
		
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;	
		
		t1.print(t1);
		//print(rangeSumBST(t1,7,15));
		print(rangeSumBSTLoop(t1,7,15));
	}
	public static void print(Object o) {
		System.out.println(o);
	}
	public static int rangeSumBST(TreeNode root, int L, int R) {
		if(root == null)
			return 0;
		if(root.val < L) 
			return rangeSumBST(root.right,L,R);
		else if(root.val > R)
			return rangeSumBST(root.left,L,R);
		else {
			return rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R)+root.val;
		}	
    } 
	public static int rangeSumBSTLoop(TreeNode root, int L, int R) {
		if(root == null)
			return 0;
		int sum = 0;
		var stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()) {
			var tempNode = stack.pop();
			int tempVal = tempNode.val;
			if(tempVal < L && tempNode.right != null) {
				stack.push(tempNode.right);
				continue;
			}
			else if(tempVal > R && tempNode.left != null) {
				stack.push(tempNode.left);
				continue;
			}else if(tempVal >= L && tempVal <= R){
				if(tempNode.left != null)
					stack.push(tempNode.left);
				if(tempNode.right != null)
					stack.push(tempNode.right);
				sum += tempVal;
			}
			
		}
		return sum;
	}
}
