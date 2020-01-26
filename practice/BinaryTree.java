package practice;

public class BinaryTree {
	public static void main(String []args) {
		BTree bt = new BTree(4);
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    
	   // bt.root.print(bt.root);
	    print(bt.contains(8));
	    bt.delete(3);
	   // bt.root.print(bt.root);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	
}
class BTree{
	TreeNode root;
	
	BTree(int val){
		root = new TreeNode(val);
	}
	void add(int val) {
		root = addRecursive(root,val);
	}
	TreeNode addRecursive(TreeNode current, int val) {
		if(current == null)
			return new TreeNode(val);
		if(val < current.val)
			current.left = addRecursive(current.left, val);
		else if(val > current.val)
			current.right = addRecursive(current.right, val);
		return current;
	}
	boolean contains(int val) {
		return findNode(root,val);
	}
	boolean findNode(TreeNode current, int val) {
		if(current == null)
			return false;
		if(current.val == val)
			return true;
		//return findNode(current.left,val) || findNode(current.right,val);
		return val < current.val ? findNode(current.left,val) : findNode(current.right,val);
	}
	void delete(int val) {
		root = deleteNode(root, val);
	}
	TreeNode deleteNode(TreeNode current, int val) {
		
		if(current.val == val) {
			
		}
		//return findNode(current.left,val) || findNode(current.right,val);

	    if(val < current.val) 
	    	current.left = deleteNode(current.left,val);
	    else
	    	current.right = deleteNode(current.right,val);
	    return current;
	}
	
}
