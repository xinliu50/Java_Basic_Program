package practice;

public class InheritanceClass extends Product {
	
	public static void main(String []args) {
		Labtop mac = new Labtop();
		mac.setProductDetail("mac", "1223", 800, "intel core 5");
		mac.printProduct();
	}
	public static void print(Object o) {
		System.out.print(o);
	}

}

class Product{
	String name;
	String id;
	double price;
	
	Product(){
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

class Labtop extends Product{
	String CPU;
	
	//overloading
	void setProductDetail(String name, String id, double price, String CPU) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.CPU = CPU;
	}
	//overriding
	void printProduct() {
		System.out.print("Name: " + name + "\n");
		System.out.print("id: " + id + "\n");
		System.out.print("price: " + price + "\n");
		System.out.print("CPU: " + CPU + "\n");
		
	}
	
}
