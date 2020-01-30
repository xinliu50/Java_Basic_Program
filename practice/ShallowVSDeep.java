//package practice;
//
////shallow copy VS deep copy
//public class ShallowVSDeep {
//	public static void main(String[]args) {
//		Person Mike = new Person(new Name("Mike","Li"),new Address(393,"Brooklyn"),30);
//		printPerson(Mike);
//		print("\n");
//		Person Amy = (Person)Mike.clonePerson();
//		printPerson(Amy);
//		print("\n");
//
//		print("after change Mike's age");
//		Mike.age = 12;
//		printPerson(Mike);
//		print("\n");
//		printPerson(Amy);
//		
//		Mike.address = new Address(100, "Manhattan");
//		print("after change Mike's address");
//		printPerson(Mike);
//		print("\n");
//		printPerson(Amy);
//		
//		
//	}
//	public static void print(Object o) {
//		System.out.print(o);
//	}
//	public static void printPerson(Person p) {
//		print("Name: "+ p.name.firstName + " " + p.name.lastName + "\n");
//		print("Address: " + p.address.streetNumber + " " + p.address.city + "\n");
//		print("Age: " + p.age + "\n");
//		
//	}
//}
//
//class Name{
//	String firstName;
//	String lastName;
//	
//	Name(String firstName, String lastName){
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//}
//class Address{
//	int streetNumber;
//	String city;
//	
//	Address(int streetNumber, String city){
//		this.streetNumber = streetNumber;
//		this.city = city;
//	}
//}
//class Person{
//	Name name;
//	Address address;
//	int age;
//	
//	Person(Name name, Address address, int age){
//		this.name = name;
//		this.address = address;
//		this.age = age;
//	}
//	
//	Object clonePerson() {
//		Person other = new Person(this.name, this.address, this.age);
//		return other;
//	}
//}