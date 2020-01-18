package practice;

import java.util.*;

public class DataStructure {
	public static void main(String []args) {
		ArrayList<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(12);
		ls.add(13);
		ls.add(15);
		ls.add(21);
		printList(ls);
		print("\n");
		var temp = (ArrayList<Integer>)ls.clone();
		printList(temp);
		print("\n");
		//temp = (ArrayList<Integer>)ls.clone();
		//printList(temp);
		ls.clear();
		printList(temp);
		print("\n");
		printList(ls);

		
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
	public static void printList(List<Integer> ls) {
		for(int num : ls) {
			print(num + ", ");
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
	
	void enqueue(int value) {
		Node newNode = new Node(value);
		if(this.head == null) {
			this.head = this.tail = newNode;
			
		}else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		//return this.head;
	}
	
	Node dequeue(){
		if(this.head == null) {
			return null;
		}
		Node temp = this.tail;
		this.tail = this.tail.prev;
		this.tail.next = null;
		return temp;
	}
}
