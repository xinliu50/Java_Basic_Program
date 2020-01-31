package practice;

import java.util.HashMap;

/*
1.Make a Map that associates the following employee IDs with names. Keys and values of Maps can
be any Object type, so in real life you would probably have the key be a String and the associated
value be a Person or Employee object. To make things simpler on this exercise, you can use String
for both the ID and the name, rather than bothering to create a Person or Employee class. The point
here is to associate keys with values, then retrieve values later based on keys.

ID      Name
a1234  Steve Jobs
a1235  Scott McNealy
a1236  Jeff Bezos
a1237  Larry Ellison
a1238  Bill Gates*/
public class DayFour3 {
	public static void main(String[] args) {
		var map = new HashMap<String, String>();
		map.put("a1234", "Steve Jobs");
		map.put("a1235", "Scott McNealy");
		map.put("a1236", "Jeff Bezos");
		map.put("a1237", "Larry Ellison");
		map.put("a1238", "Bill Gates");
		
		for(String i : map.keySet()) {
			System.out.println(i + ": " + map.get(i));
		}
		
	}

}
