package practice;
/*In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.*/

public class MatrixReshape {
	public static void main(String[]args) {
		int[][] input = {{1,2,3,4}};
		printArray(matrixReshape(input,2,2));
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void printArray(int[][] arr) {
		print("[");
		for(int i = 0; i < arr.length; i ++) {
			print("[");
			for(int j = 0; j < arr[i].length; j ++) {
				print(arr[i][j] + ",");
			}
			print("]");
		}
		print("]");
	}
	public static int[][] matrixReshape(int[][] nums, int r, int c){
		int row = nums.length;
		int col = nums[0].length;
		int rr = 0, cc = 0;
		
		if(row*col != r*c)
			return nums;
		
		int[][] result = new int[r][c];
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j ++) {
				result[rr][cc] = nums[i][j];
				if( cc >= c-1) {
					rr ++;
					cc = 0;
					continue;
				}
				cc++;
			}
		}
		return result;
	}
}
