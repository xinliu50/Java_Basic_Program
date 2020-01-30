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
		var link = new LinkedList<Integer>();
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
			
		}
	
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
class data implements Collection{

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}




















//class Customer{
//	//properties
//	//actions
//	String first;
//	String last;
//	long phoneNumber;
//	float balance = 8000;
//	public void transfer(float a) {
//		if(a<=balance) {
//			balance = balance - a;
//			System.out.println("Money has been transfer");
//			System.out.println(balance);
//		}
//		else
//			System.out.println("no funds");
//	}
//	public void deposit(float f) {
//		
//	}
//	
//}
//class DefenceCustomer extends Customer{
//	//overloading
//	public void deposit(float f, int number) {
//		//diff input param
//	}
//	//overriding 
//	public void transfer(float a) {
//		//same param
//		//diff implementation
//	}
//	public  void withdraw() {
//		
//	}
//	
//	
//}
//class Employee{
//	int empid;
//	String ename;
//	public Employee() {
//		this.empid = 123;
//		this.ename = "Amy";
//	}
//	public void getSalaryDetails() {
//		
//	}
//}
//
//class one{
//	int i = 16;
//	
//	one(){
//		System.out.print("this is from super default\n");
//	}
//	one(int i){
//		System.out.print("this is from super i constructor\n");
//	}
//}
//class two extends one{
//	int i = 20;
//	two(){
//		System.out.print("this is from child default\n");
//	}
//	two(int i){
//		//super(i);
//		System.out.print("this is from child i constructor\n");
//	}
//}
//class Student123{
//	//instance variable
//	//the value of these variable is different from object to object
//	int stuid;
//	String name;
//	long number;
//	static int count = 0;
//	
//	static String course = "Java"; //static variable. the value of static variable is same for all objects
//	
//	Student123(int i){
//		count ++;
//	}
//	void getDetails() {
//		int x = 123; //local variable
//		System.out.print(course);
//	}
//	static int getStudentCount() {
//		System.out.print(course);
//		return count; //static function can only access static variable
//	}
//}
///*
// * class Test{
// * 	instance var
// * 	static var
// * 	instance block
// * 	static block
// * 	constructor
// * 	instance functions
// * 	static functions
// * 
// * 
// * }
// * */
//class staticBlock{
//	public int a = 12;
//	static int k = 23;
//	//applications run static block before running main
//	//to load third party libraries
//	//System.load("Python libraries")
//	static {
//		
//		System.out.println("In static block");
//	}
//	//instance block
//	//when creating staticBlock object, before calling default constructor, run instance block
//	{
//		System.out.println("In instance block");
//	}
//	staticBlock(){
//		
//	}
//	staticBlock(int i){
//		
//	}
//}
//class School{
//	String name;
//	int id;
//	School(String name, int id){
//		this.name = name;
//		this.id = id;
//	}
//	void test() {
//		System.out.println(name);
//		System.out.println(id);
//	}
//}
//
//
