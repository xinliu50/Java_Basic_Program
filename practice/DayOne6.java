package practice;

public class DayOne6 {
	public static void main(String[]args) {
		Student s = new Student("xin","Liu", new Address(484 ,"60th Brooklyn,New York, 11220"), 
				new Address(500,"Bedford"));
		System.out.print(s);
	}
	
}
/*constructor
1. Modify the Student class presented as follows. Each
student object should also contain the scores for three tests. Provide
a constructor that sets all instance values based on parameter values.
Overload the constructor such that each test score is assumed to be
initially zero. Provide a method called setTestScore that accepts
two parameters: the test number (1 through 3) and the score. Also
provide a method called getTestScore that accepts the test number
and returns the appropriate score. Provide a method called average
that computes and returns the average test score for this student.
Modify the toString method such that the test scores and average
are included in the description of the student. create a class
with main method to exercise the new Student methods.
}*/
class Student
{
	private String firstName, lastName;
	private Address homeAddress, schoolAddress;
	private int s1, s2, s3;
	//-----------------------------------------------------------------
	// Sets up this Student object with the specified initial values.
	//-----------------------------------------------------------------
	public Student (String first, String last, Address home,
	Address school)
	{
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
		s1 = 0;
		s2 = 0;
		s3 = 0;
	}

	public void setTestScore(int num, int score) {
		if(num == 1) 
			s1 = score;
		else if(num == 2)
			s2 = score;
		else if(num == 3)
			s3 = score;
	}
	public int getTestScore(int num) {
		if(num == 1) 
			return s1;
		else if(num == 2)
			return s2;
		else if(num == 3)
			return s3;
		return -1;
	}
	public double average() {
		return (s1+s2+s3)/3.0;
	}
	//-----------------------------------------------------------------
	// Returns this Student object as a string.
	//-----------------------------------------------------------------
	public String toString()
	{
		String result;
		result = firstName + " " + lastName + "\n";
		result += "Home Address:\n" + homeAddress + "\n";
		result += "School Address:\n" + schoolAddress + "\n";
		result += "Test 1: " + s1 + "\n";
		result += "Test 2: " + s2 + "\n";
		result += "Test 3: " + s3 + "\n";
		result += "Test average: " + average() + "\n";
		return result;
	}
}