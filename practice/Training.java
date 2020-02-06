package practice;

import java.util.*;
import java.util.Map.Entry;
public class Training {
	public static void main(String []args) {
		var map = new TreeMap<Integer,Integer>(Collections.reverseOrder());
		map.put(1, 3);
		map.put(2, 22);
		map.put(122, 20);
		map.put(32, 11);
		map.put(22, 44);
		map.put(42, 100);
		System.out.println(map);
		Set<Entry<Integer, Integer>> en = map.entrySet();
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