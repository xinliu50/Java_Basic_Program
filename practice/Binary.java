package practice;

import java.util.ArrayList;

public class Binary {
	public static void main(String []args) {
		//convert a string to binary and save it to the integer
		String num = "0";
		int binary = Integer.parseInt(num,2);
		print(binary);
		//convert a decimal to a binary save it to string
		int mynum = 0;
		String mybinary = Integer.toBinaryString(mynum);
		print(mybinary);
		print("implement own binary methods");
		int decimal = binaryToDecimal(111);
		print("binaryToDecimal: " + 111 + " is " + decimal);
		int decimal1 = binaryToDecimal(1);
		print("binaryToDecimal: " + 1 + " is " + decimal1);
		
		String myBinaryString = DecimalToBinaryIntoString(10);
		print("DecimalToBinaryIntoString: " + 10 + " is " + myBinaryString);
		String myBinaryString1 = DecimalToBinaryIntoString(0);
		print("DecimalToBinaryIntoString: " + 0 + " is " + myBinaryString1);
		
		
		int result = DecimalToBinaryIntoNumber(10);
		print("DecimalToBinaryIntoNumber: " + 10 + " is " + result);
		int result1 = DecimalToBinaryIntoNumber(1);
		print("DecimalToBinaryIntoNumber: " + 1 + " is " + result1);
		
		int NonString = DecimalToBinaryIntoNumberNonString(10);
		print("DecimalToBinaryIntoNumberNonString: " + 10 + " is " + NonString);
		int NonString1 = DecimalToBinaryIntoNumberNonString(1);
		print("DecimalToBinaryIntoNumberNonString: " + 1 + " is " + NonString1);
		
		print("TwoBinarySum: 111 and 100 is: " + TwoBinarySum(111,100));
		print("TwoBinarySum: 111111 and 100 is: " + TwoBinarySum(111111,100));
		
		print("TwoBinarySum taking Strings as input: 111, 100 sum is " + TwoBinarySum("111","100"));
		print("TwoBinarySum taking Strings as input: 1111, 111 sum is " + TwoBinarySum("1111","111"));

		
 	}
	public static void print(Object o) {
		System.out.println(o);
	}
	public static int binaryToDecimal(int binary) {
		int decimal = 0;
		int n = 0;
		while(true) {
			if(binary == 0)
				break;
			decimal += binary%10*Math.pow(2,n);
			n++;
			binary = binary/10;
		}
		return decimal;
	}
	public static String DecimalToBinaryIntoString(int decimal) {
		String result = "";
		if(decimal == 0)
			return "0";
		while(decimal != 0) {
			result += decimal%2;
			decimal = decimal/2;
		}
		String myBinaryString = "";
		for(int i = result.length()-1; i >= 0; i --) {
			myBinaryString += result.charAt(i);
		}
		return myBinaryString;
	}
	public static int DecimalToBinaryIntoNumber(int decimal) {
		//using strings
		String temp = DecimalToBinaryIntoString(decimal);
		int result = 0;

		result = Integer.parseInt(temp);
		return result;
	}
	//not using strings
	public static int DecimalToBinaryIntoNumberNonString(int decimal) {
		var ls = new ArrayList<Integer>();
	
		while(decimal != 0) {
			ls.add(decimal%2);
			decimal = decimal/2;
		}
		int result = 0;
		for(int i = 0; i < ls.size(); i++) {
			result += ls.get(i) * Math.pow(10,i);
		}
		return result;
	}
	
	//adding two binary numbers
	public static int TwoBinarySum(int num1, int num2) {
		String str1 = num1 + "";
		String str2 = num2 + "";
		int len1 = str1.length();
		int len2 = str2.length();
		int carry = 0;
		String temp = "";
		int max = Math.max(len1, len2);
		for(int i = 0; i < max; i ++){
			int p = i < len1 ? str1.charAt(len1-1-i) - '0' : 0;
			int q = i < len2 ? str2.charAt(len2-1-i) - '0' : 0;
			int sum = q + p + carry;
			carry = sum/2;
			temp = sum%2 + temp;
		}
		temp = carry == 1 ? "1" + temp : temp;
		
		return Integer.parseInt(temp);
	}
	public static String TwoBinarySum(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int max = Math.max(len1, len2);
		String temp = "";
		int carry = 0;
		for(int i = 0; i < max; i++) {
			int p = i < len1 ? num1.charAt(len1-1-i) - '0' : 0;
			int q = i < len2 ? num2.charAt(len2-1-i) - '0' : 0;
			int num = q + p + carry;
			carry = num/2;
			temp = num%2 + temp;
		}
		temp = carry == 1 ? "1" + temp : temp;
	
		return temp;
	}
}
