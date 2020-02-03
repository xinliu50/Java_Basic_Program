package practice;
import java.util.*;
public class ShiritoriGame {

	public static void main(String[] args) {
		
		var ls = game();
		for(int i = 0; i < ls.size(); i ++) {
			System.out.println(ls.get(i) + ", ");
		}
	}
	public static ArrayList<String> game() {
		Scanner sc = new Scanner(System.in);
		var map = new HashMap<String,Integer>();
		var ls = new ArrayList<String>();
		
		System.out.println("Enter your word(Stop if you type stop):");
		String input = sc.nextLine();
		while(!input.equals("stop")) {
			if(!map.isEmpty() && map.containsKey(input))
				System.out.println("Invalid!" + input + "has been said!");
			else if(!map.isEmpty() && ls.get(ls.size()-1).charAt(ls.get(ls.size()-1).length()-1) != input.charAt(0))
				System.out.println("Invalid! - " + input + "should start with" + ls.get(ls.size()-1).charAt(ls.get(ls.size()-1).length()-1));
			else {
				ls.add(input);
				map.put(input, 0);
				System.out.println("valid!!!!");
			}
			System.out.println("Enter your word(Stop if you type stop):");
			input = sc.nextLine();
		}
		return ls;
	}
}
