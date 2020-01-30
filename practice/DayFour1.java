package practice;

/*Given an array of 50 integers where all numbers from 1 through 50 show up in no 
 * particular order except for one number. In the place of a missing number there 
 * is a repeating number. For example - the sequence can be [3, 12, 19, 1, 24, 3,.....]. 
 * Write a method to find the repeating number in using java*/
public class DayFour1 {
	public static void main(String []args) {
		int[]a =  {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,
				32,33,34,35,36,37,38,39,40,41,42,46,43,45,44,45,47,48,49};
		System.out.println(findRepeat(a));
	}
	public static int findRepeat(int[] arr) {
		boolean []visited = new boolean[51];
		for(int i = 0; i < 50; i ++) {
			if(visited[arr[i]]) {
				return arr[i];
			}
			if(!visited[arr[i]]) {
				visited[arr[i]] = true;
			}
		}
		return -1;
	}
}
