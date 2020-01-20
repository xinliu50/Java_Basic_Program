package practice;

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
		print("DecimalToBinaryIntoString: " + 10 + "is " + myBinaryString);
		String myBinaryString1 = DecimalToBinaryIntoString(0);
		print("DecimalToBinaryIntoString: " + 0 + "is " + myBinaryString1);
		String myBinaryString2 = DecimalToBinaryIntoString(3);
		print("DecimalToBinaryIntoString: " + 3 + "is " + myBinaryString2);


		
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
}
