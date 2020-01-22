package practice;
import java.util.*;

public class ContainsDuplicate {
	public static void main(String[]args) {
		int[] num = {1,1,1,3,4};
		print(containsDuplicate(num));
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> mySet = new HashSet<>();
		for(int i : nums) {
			if(!mySet.add(i))
				return true;
		}
		return false;
	}
}
