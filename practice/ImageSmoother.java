package practice;

/**Given a 2D integer matrix M representing the gray scale of an image, 
 * you need to design a smoother to make the gray scale of each cell becomes 
 * the average gray scale (rounding down) of all the 8 surrounding cells and itself. 
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 * 
 * Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * @author xinliu
 *
 */
public class ImageSmoother {
	public static void main(String []args) {
		int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] result = imageSmoother(input);
		printArray(result);
		print("\n");
		int[][] result1 = imageSmoother1(input);
		printArray(result1);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void printArray(int[][] M) {
		print("[");
		for(int i = 0; i < M.length; i++) {
			print("[");
			for(int j = 0; j < M[i].length; j ++) {
				print(M[i][j]+",");
			}
			print("],");
		}
		print("]");
	}
	public static int[][] imageSmoother(int[][] M){
		int[][] result = new int[M.length][M[0].length];
		for(int i = 0; i < M.length; i ++) {
			for(int j = 0; j < M[i].length; j ++) {
				result[i][j] = (int)value(i,j,M.length, M[i].length,M);
			}
		}
		return result;
	}
	public static double value(int i, int j, int row, int col, int[][] M) {
		int topLeft = 0; // = i - 1 >= 0 && j - 1 >= 0 ? M[i-1][j-1] : 0;
		int count = 0;
		if(i - 1 >= 0 && j - 1 >= 0) {
			topLeft = M[i-1][j-1];
			count ++;
		}
		int top = 0; //i - 1 >= 0 ? M[i-1][j] : 0;
		if(i - 1 >= 0) {
			top = M[i-1][j];
			count ++;
		}
		int topRight = 0; //i - 1 >= 0 && j + 1 < col ? M[i-1][j+1] : 0;
		if(i - 1 >= 0 && j + 1 < col) {
			topRight = M[i-1][j+1];
			count ++;
		}
		int left = 0; //j - 1 >= 0 ? M[i][j-1] : 0;
		if(j - 1 >= 0) {
			left = M[i][j-1];
			count ++;
		}
		int right = 0;//j + 1 < col ? M[i][j+1] : 0;
		if(j + 1 < col) {
			right = M[i][j+1];
			count ++;
		}
		int downLeft = 0;//i + 1 < row && j - 1 >= 0 ? M[i+1][j-1] : 0;
		if(i + 1 < row && j - 1 >= 0) {
			downLeft = M[i+1][j-1];
			count ++;
		}
		int down = 0;//i + 1 < row ? M[i+1][j] : 0;
		if(i + 1 < row) {
			down = M[i+1][j];
			count ++;
		}
		int downRight = 0;//i + 1 < row && j + 1 < col ? M[i+1][j+1] : 0;
		if(i + 1 < row && j + 1 < col) {
			downRight = M[i+1][j+1];
			count ++;
		}
		int self = M[i][j];
		count ++;
		return Math.floor((topLeft+top+topRight+left+right+downLeft+down+downRight+self)/count*1.0);
	}
	
	public static int[][] imageSmoother1(int[][] M){
		int[][] result = new int[M.length][M[0].length];
		int count = 0;
		int row = M.length;
		int col = M[0].length;
		
		for(int i = 0; i < M.length; i ++) {
			for(int j = 0; j < M[i].length; j++) {
				count = 0;
				for(int ni = i - 1; ni <= i + 1; ni ++) {
					for(int nj = j - 1; nj <= j + 1; nj ++) {
						if( ni >= 0 && ni < row && nj >= 0 && nj < col) {
							result[i][j] += M[ni][nj];
							count ++;	
						}
					}
				}
				result[i][j] = result[i][j]/count;
			}
		}
		return result;
	}
}
