package practice;

class Test { 
    //static int i; 
    static int j = 2; 
      
    // start of static block  
    static { 
       // i = 10; 
        System.out.println("static block called "); 
    } 
    // end of static block  
} 
  
class Main { 
    public static void main(String args[]) { 
  
        // Although we don't have an object of Test, static block is  
        // called because i is being accessed in following statement. 
    	 System.out.println("In main");
        System.out.println(Test.j);  
       
    } 
} 