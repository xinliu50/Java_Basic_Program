package practice;

//Practicing Inner classes 
public class ClassPractice {
	public static void main(String []args) {
		OutHello oh = new OutHello();
		oh.hello.show();
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	
	//Static nested classes
    static class StaticInner{
    	static void printMe() {
    		print("this is from static inner");
    	}
    }
	
}


//Nested Inner class
class Outer{
	private int a = 12;
	class Inner{
		private int b = 10;
		void printMe() {
			System.out.print(a);
		}
	}
}

//Method Local Inner classes
class MethodLocalOuter{
	void printMe() {
		class Inner{
			private int b = 10;
		}
		System.out.print(new Inner().b);
	}
}


//Anonymous inner classes
//1.As subclass of specified type
class subOuter{
	subInner sb = new subInner() {
		void show() {
			System.out.print("This is from subInner");
		}
	};
}
class subInner{
	void show() {
		System.out.print("This is from subInner");
	}
}

//2.As implementer of the specified interface
interface Hello{
	void show();
}
class OutHello{
	Hello hello = new Hello() {
		public void show() {
			System.out.print("this is from outerHello");
		}
	};
}
