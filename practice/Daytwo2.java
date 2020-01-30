package practice;

import java.util.Date;

public class Daytwo2 {
	public static void main(String[]args) {
		Person mike = new Person("Mike", "Brooklyn, NY", "736528293", "Mike@yahoo.com");
		println(mike);
		
		Student Amy = new Student("Amy", "Mahattan NY", "43873873", "Amy@gmail.com", "Senior");
		println(Amy);
		
		Employee Miya = new Employee("Miya", "Mahattan NY", "28386838", "miya@gmail.com", "M27",5000, new Date());
		println(Miya);
		
		Faculty wu = new Faculty("wu", "Mahattan NY", "38682883", "wu@gmail.com", "N12",3000, new Date(), "4:30-7:30",2);
		println(wu);
		
		Staff chen = new Staff("chen", "Mahattan NY", "28638638", "chen@gmail.com", "N12",4000, new Date(), "Professor");
		println(chen);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
}
class Person{
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	
	
	public Person(String name, String address, String phoneNumber, String email) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}
	
}
class Student extends Person{
	private final String classStatus;
	
	public Student(String name, String address, String phoneNumber, String email, String classStatus) {
		super( name,  address, phoneNumber, email);
		this.classStatus = classStatus;
	}

	public String getClassStatus() {
		return classStatus;
	}

	@Override
	public String toString() {
		return "Student "+ super.toString() + "[classStatus=" + classStatus + "]";
	}

	
}
class Employee extends Person{
	private String office;
	private double salary;
	Date dateHired;
	
	public Employee(String name, String address, String phoneNumber, String email, String office, double salary,
			Date dateHired) {
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	@Override
	public String toString() {
		return "Employee "+ super.toString() + "[office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + "]";
	}
	 
}

class Faculty extends Employee{
	private String officeHours;
	private int rank;
	public Faculty(String name, String address, String phoneNumber, String email, String office, double salary,
			Date dateHired, String officeHours, int rank) {
		super(name, address, phoneNumber, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	public String getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Faculty " + super.toString() + "[officeHours=" + officeHours + ", rank=" + rank + "]";
	} 
}
class Staff extends Employee{
	private String title;

	public Staff(String name, String address, String phoneNumber, String email, String office, double salary,
			Date dateHired, String title) {
		super(name, address, phoneNumber, email, office, salary, dateHired);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff " + super.toString() + "[title=" + title + "]";
	}
	
}