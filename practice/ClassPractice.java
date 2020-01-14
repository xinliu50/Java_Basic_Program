package practice;

//Practicing Inner classes 
public class ClassPractice {
	public static void main(String []args) {
//		Outer o = new Outer();
//		Outer.Inner in = o.new Inner();
//		in.output();
//		MLOuter o = new MLOuter();
//		o.printMe();
		
		//Inner.printInner(); //It's just like a static member of outside class
		
//		Demo demo = new Demo();
//		demo.show();
//		print("\n");
//		InnerDemo indemo = new InnerDemo();
//		indemo.demo.show();
		InnerfaceDemo inF = new InnerfaceDemo();
		inF.h.show();
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	
	//Static nested classes
    static class Inner{
    	public static void printInner() {
    		print("this is from Inner");
    	}
    }
	
}


//Nested Inner class
class Outer{
	private String c = "Outer c";
	String b = "public";
	static int k = 1;
	
	public String getC() {
		return c;
	}
	class Inner{
		private String a = "Inner c";
		Outer o;
		public void output(){
			System.out.print(c);
		}
	}
}

//Method Local Inner classes
class MLOuter{
	int x = 10;
	public void printMe() {
		System.out.print("from Outer\n");
		final int y = 20;
		//Local inner class cannot access non-final local variable 
		//till JDK 1.7. Since JDK 1.8, it is possible to access the non-final 
		//local variable in method local inner class.

		class Inner{
			void printMe() {
				System.out.print("from inner\n");
				System.out.print(x+"\n");
				System.out.print(y+"\n");
			}
		}
		
		Inner in = new Inner();
		in.printMe();
	}
}
//Anonymous inner classes
//1.As subclass of specified type
class Demo{
	void show() {
		System.out.print("this is from outer demo");
	}
}

class InnerDemo{
	Demo demo = new Demo() {
		void show() {
			System.out.print("this is from inner demo");
		}
	};
}

//2.As implementer of the specified interface
interface Hello{
	void show();
}

class InnerfaceDemo{
	 Hello h = new Hello() {
	  public void show() {
		  System.out.print("From Innerface demo");
	  }
	};
}

