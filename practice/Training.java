package practice;

class Customer{
	//properties
	//actions
	String first;
	String last;
	long phoneNumber;
	float balance = 8000;
	public void transfer(float a) {
		if(a<=balance) {
			balance = balance - a;
			System.out.println("Money has been transfer");
			System.out.println(balance);
		}
		else
			System.out.println("no funds");
	}
	public void deposit(float f) {
		
	}
	
}
class DefenceCustomer extends Customer{
	
	public  void withdraw() {
		
	}
	
	
}
class Employee{
	int empid;
	String ename;
	public Employee() {
		
	}
	public void getSalaryDetails() {
		
	}
}

public class Training {
	public static void main(String []args) {
		Customer c = new Customer();
		c.transfer(3000);
		Employee e = new Employee();
	}
	public static void print(Object o) {
		System.out.print(o);
	}
}
