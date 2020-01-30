//package practice;
//
//public class Training {
//	public static void main(String []args) {
//		
//		two t = new two();
//		two t1 = new two(2);
//		
//	}
//	public static void print(Object o) {
//		System.out.print(o);
//	}
//	
//}
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
