package practice;

public class DataStructure {
	public static void main(String []args) {
		SingleLinkedList stack = new SingleLinkedList();
		stack.push(12);
		
		printStack(stack);
		print("\n");
		stack.pop();
		printStack(stack);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void printStack(SingleLinkedList stack) {
		Node temp = stack.top;
		
		while(temp != null) {
			print(temp.value + " -> ");
			temp = temp.next;
		}
	}
}

//class Node{
//	int value;
//	Node next;
//	Node(int value){
//		this.value = value;
//		this.next = null;
//	}
//}
class SingleLinkedList{
	Node top;
	
	SingleLinkedList(){
		top = null;
	}
	
	Node push(int val) {
		Node pushNode = new Node(val);
		pushNode.next = this.top;
		this.top = pushNode;
		return pushNode;
	}
	
	Node pop() {
		
		if(top == null) {
			return top;
		}
		this.top = this.top.next;
		return top;
	}
}

class Node{
	int value;
	Node next;
	Node prev;
	Node(int value){
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
class DoubleLinkedList{
	Node front;
	Node back;
	
	DoubleLinkedList(){
		this.front = null;
		this.back = null;
	}
	
	Node enqueue(int value) {
		Node newNode = new Node(value);
		
	}
	
	
}
//class Queue{
//	
//	
//	int enqueue(int value) {
//		
//	}
//	int dequeue() {
//		
//	}
//}