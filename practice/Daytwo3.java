package practice;


public class Daytwo3 {
	public static void main(String[]args) {
		Rectangle re = new Rectangle();
		re.printArea();
		Triangle tr = new Triangle();
		tr.printArea();
		Circle ci = new Circle();
		ci.printArea();
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
}
abstract class shape{
	int a = 4;
	int b = 20;
	abstract void printArea();
}
class Rectangle extends shape{

	@Override
	void printArea() {
		// TODO Auto-generated method stub
		System.out.println(a*b);
	}
	
}
class Triangle extends shape{

	@Override
	void printArea() {
		// TODO Auto-generated method stub
		System.out.println(a*b/2);
	}
	
}
class Circle extends shape{

	@Override
	void printArea() {
		// TODO Auto-generated method stub
		System.out.println(Math.PI*Math.pow(a, 2));
	}
	
}