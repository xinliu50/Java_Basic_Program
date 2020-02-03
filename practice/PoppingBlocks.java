package practice;
import java.util.*;
public class PoppingBlocks {

	public static void main(String[] args) {
		
		var ls = new ArrayList<Character>();
		ls.add('A');
		ls.add('B');
		ls.add('C');
		ls.add('C');
		ls.add('B');
		ls.add('D');
		ls.add('A');
		char [] c = popping(ls);
		print(c);
		
//		var ls1 = new ArrayList<Character>();
//		ls1.add('A');
//		ls1.add('B');
//		ls1.add('A');
//		ls1.add('A');
//		ls1.add('A');
//		ls1.add('B');
//		ls1.add('B');
//		char [] c1 = popping(ls1);
//		print(c1);
	}
	public static void print(char[]c) {
		System.out.print("[");
		for(char s : c)
			System.out.print(s + ", ");
		System.out.println("]");
	}
	public static char[] popping(ArrayList<Character> ls){
		
	    var stack = new Stack<Character>();
	    int i = 0;
		while(i != ls.size()){
			if(!stack.empty() && stack.peek() != ls.get(i)) {
				stack.push(ls.get(i));
			}else if(!stack.empty() && stack.peek() == ls.get(i)){
				char temp = stack.pop();			
				while(i != ls.size()-1 && ls.get(i+1) == temp) {	
					i++;
				}
				
			}else if (stack.empty() || stack.peek() != ls.get(i)){
				stack.push(ls.get(i));
			}
			i++;
		}
		var result = new char[stack.size()];
		for(int j = result.length - 1; j >= 0; j --) {
			result[j] = stack.pop();
		}
		return result;
	}
}
