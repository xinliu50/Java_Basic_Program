package practice;
/*An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].*/
import java.util.*;

public class FloodFill {
	public static void main(String []args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		printArray(image);
		print("\n");
		
		
		printArray(floodFillStack(image,1,1,2));
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void printArray(int[][]a) {
		print("{");
		for(int i = 0; i < a.length; i ++) {
			print("[");
			for(int j = 0; j < a[i].length; j++) {
				print(a[i][j] + ", ");
			}
			print("],");
		}
		print("}");
	}
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
		int color = image[sr][sc];
		if(color != newColor)
			DFS(image,color,sr,sc,newColor);
		return image;
	}
	public static void DFS(int[][] image,int color, int sr, int sc, int newColor) {
		if(image[sr][sc] == color) {	
			image[sr][sc] = newColor;
			if(sr >= 1) {
				DFS(image, color, sr-1, sc, newColor);
			}
			if(sc >= 1) {
				DFS(image, color, sr, sc-1, newColor);
			}
			if(sr < image.length-1) {
				DFS(image, color, sr++, sc, newColor);
			}
			if(sc < image[0].length-1) {
				DFS(image, color, sr, sc++, newColor);
			}
		}
	}
	public static int[][] floodFillStack(int[][] image, int sr, int sc, int newColor){
		var stack = new Stack<MyPair>();
		int rn = image.length;
		int cn = image[0].length;
		int color = image[sr][sc];
		boolean[][] visited = new boolean [rn][cn];
		if(color == newColor)
			return image;
		stack.push(new MyPair(sr,sc));
		while(!stack.empty()) {
			var p = stack.pop();
			int r = p.getFirst();
			int c = p.getSecond();
			visited[r][c] = true;
			print("r: " + r + " c: " + c + "\n");
			image[r][c] = newColor;
			if(r >= 1 && !visited[r-1][c] && image[r-1][c] == color) {
				stack.push(new MyPair(r-1,c));
			}
			if(c >= 1 && !visited[r][c-1] && image[r][c-1] == color) {
				stack.push(new MyPair(r,c-1));
			}
			if(r < rn - 1 && !visited[r+1][c] && image[r+1][c] == color) {
				stack.push(new MyPair(r+1,c));
			}
			if(c < cn - 1 && !visited[r][c+1] && image[r][c+1] == color) {
				stack.push(new MyPair(r,c+1));
			}
		}
		return image;
		
	}
}
class MyPair{
	private int first;
	private int second;
	MyPair(int first, int second){
		this.first = first;
		this.second = second;
	}
	int getFirst() {
		return this.first;
	}
	int getSecond() {
		return this.second;
	}
}
