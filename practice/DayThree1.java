package practice;

public class DayThree1 {

	public static void main(String[] args) {
		var a = new IntegerArrayMath();
		a.integerDivision();
	}
}
class NonIntResultException extends Exception{
	
	NonIntResultException(int num1, int num2){
		System.out.println(num1 + " divided by "+ num2 + " is not an integer");
	}
}
class IntegerArrayMath
{
	int[] number;
	int[] denom;
	
	IntegerArrayMath(){
		number = new int[3];
		denom = new int[3];
		
		number[0] = 4;
		number[1] = 8;
		number[2] = 15;
		
		denom[0] = 2;
		denom[1] = 0;
		denom[2] = 4;
	}
	
	//NonIntResultException class code goes here
	public void integerDivision() 
	{
		for(int i = 0; i < 3; i ++) {
			int result = -1;
			try {
				result = number[i]%denom[i];
				if(result != 0) {
					throw new NonIntResultException(number[i],denom[i]);	
				}
				System.out.println(number[i] + " divided by "+ denom[i]+ " is " + number[i]/denom[i]);
			}catch(ArithmeticException e) {
				System.out.println(e.toString());
			} catch (NonIntResultException e) {
				System.out.println("NonIntResultException catched");
			}
			continue;
		}
	}
}

