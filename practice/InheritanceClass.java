package practice;

public class InheritanceClass{
	
	public static void main(String []args) {
		Labtop mac = new Labtop();
		mac.setProductDetail(800, "intel core 5");
		mac.printProduct();
	}
	public static void print(Object o) {
		System.out.print(o);
	}

}

class Product1{
	String name;
	String id;
	double price;
	
	Product1(){
		System.out.print("This is from product\n");
	}
	
	void setProductDetail(String name, String id, double price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}
	void printProduct() {
		System.out.print("Name" + name + "\n");
		System.out.print("id" + id + "\n");
		System.out.print("price" + price + "\n");
		
	}
}

class Labtop extends Product1{
	String CPU;
	
	//overloading
	void setProductDetail(String name, String id, double price, String CPU) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.CPU = CPU;
	}
	
	//overloading
	String setProductDetail(double price, String CPU) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.CPU = CPU;
		return name;
	}
	
	//overriding
	void printProduct() {
		System.out.print("Name: " + name + "\n");
		System.out.print("id: " + id + "\n");
		System.out.print("price: " + price + "\n");
		System.out.print("CPU: " + CPU + "\n");
		
	}
}
