package practice;
import java.util.*;

public class LinkedHashMapPractice {
	public static void main(String []args) {
		Map<Integer, String> ls = new LinkedHashMap<>();
		ls.put(1, "a");
		ls.put(2, "b");
		ls.put(3, "c");
		ls.put(4, "d");
		print(ls);
	}

	public static void print(Object o) {
		System.out.print(o);
	}
}

