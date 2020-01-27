package practice;

public class BinaryTree {
	public static void main(String []args) {
		BTree tree = new BTree(50); 
		  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
        20   40  60   80 */
     
        tree.add(30); 
        tree.add(20); 
        tree.add(40); 
        tree.add(70); 
        tree.add(60); 
        tree.add(80); 
  
        System.out.println("Inorder traversal of the given tree"); 
        tree.root.print(tree.root);
  
        System.out.println("\nDelete 20"); 
        tree.delete(20); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.root.print(tree.root);
  
        System.out.println("\nDelete 30"); 
        tree.delete(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.root.print(tree.root);
  
        System.out.println("\nDelete 50"); 
        tree.delete(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.root.print(tree.root);
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
		if(current == null)
			return null;
		
		if(current.val == val) {
			if(current.left == null && current.right == null)
				return null;
			if(current.left == null)
				return current.right;
			if(current.right == null)
				return current.left;
			//have both children
			current.val = min(current.right);
			current.right = deleteNode(current.right,current.val);			
		}
		//return findNode(current.left,val) || findNode(current.right,val);

	    if(val < current.val) 
	    	current.left = deleteNode(current.left,val);
	    else
	    	current.right = deleteNode(current.right,val);
	    return current;
	}
	int min(TreeNode current) {
		int min = current.val;
		while(current.left != null) {
			min = current.left.val;
			current = current.left;
		}
		return min;
	}
	
}
