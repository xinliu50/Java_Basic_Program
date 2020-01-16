package practice;

public class DataStructure {
	public static void main(String []args) {
		Queue q = new Queue();
		q.enqueue(2);
		q.enqueue(22);
		q.enqueue(21);
		q.enqueue(123);

		printQueue(q);
		print("\n");
		printReverseQueue(q);
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
	public static void printQueue(Queue q) {
		Node temp = q.head;
		while(temp != null) {
			print( temp.value + "->");
			temp = temp.next;
		}
	}
	public static void printReverseQueue(Queue q) {
		Node temp = q.tail;
		while(temp != null) {
			print( temp.value + "<-");
			temp = temp.prev;
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
class Queue{
	Node head;
	Node tail;
	
	Queue(){
		this.head = null;
		this.tail = null;
	}
	
	Node enqueue(int value) {
		Node newNode = new Node(value);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		return this.head;
	}
	
	
}
