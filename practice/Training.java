package practice;

import java.util.*;
public class Training {
	public static void main(String []args) {
		//exception();
//		ArrayIndexOutOfBoundsException ar = new ArrayIndexOutOfBoundsException("exc");
//		throw ar;
//		Scanner sc = new Scanner(System.in);
//		println("Enter your number");
//		int a = sc.nextInt();
//		try {
//			if(a == 0) {
//				throw new InvalidAccountType();
//			}
//			else {
//				println("hi");
//			}
//		}catch(InvalidAccountType e) {
//			println("cat");
//		}
		
//		var a = new ArrayList<Integer>();
//		a.add(2);
//		a.add(22);
//		a.add(23);
//		a.add(211);
//		a.add(20);
//		a.add(210);
//		println(a);
//		for(Integer i:a) {
//			print(i + ",");
//		}
//		var it = a.iterator();
//		while(it.hasNext()) {
//			println(it.next());
			
//		}
	/*	var link = new LinkedList<Integer>();
		link.add(2);
		link.add(12);
		link.add(94);
		link.add(19);
		link.add(30);
		link.add(40);
		var it = link.listIterator();
		while(it.hasNext()) {
			int num = it.next();
			println(num);
			if(num == 19)
				it.remove();
		}
		
		println("");
		var it1 = link.iterator();
		while(it1.hasNext()) {
			println(it1.next());
			
		}*/
		
		var ls = new ArrayList<Student1>();
		ls.add(new Student1(223,"ma"));
		ls.add(new Student1(113,"amy"));
		ls.add(new Student1(023,"mike"));
		ls.add(new Student1(333,"ss"));
		Collections.sort(ls);
		System.out.println(ls);
		//Collections.sort(ls);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	public static void exception() {
		try {
			int[] a = {1,2};
			a[4] = 0;
			
		}catch(Exception e) {
			print("error");
		}
		finally {
			
		}
	}
	
}
//custom exception
class InvalidAccountType extends RuntimeException{
	
	InvalidAccountType(){
		
	}
}
class Student1 implements Comparable{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Student1(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		Student1 a = (Student1)o;
		if(this.id < a.getId())
			return 1;
		return -1;
	}
	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + "]";
	}
	
	
}

//class Gen{
//	int []a = {1,3,4,5};
//	public <E> void print() {
//		
//	}
//	public static<E> E get(int index) {
//		
//	}
//}