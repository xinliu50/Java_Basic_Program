package practice;

public class Interview {
	public static void main(String []args) {
		
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static boolean[][] findHighPoints(int[][] elevations) {
		boolean [][] m = new boolean [elevations.length][elevations[0].length];
		int rl = elevations.length;
		int cl = elevations[0].length;
		for(int i = 0; i < rl; i ++) {
			for(int j = 0; j < cl; j ++) {
				m = find(elevations,i,j,m);
			}
		}
        return find(elevations,0,0,m);
    }
	public static boolean[][]find(int[][] e, int r, int c, boolean[][] m){
		int rl = e.length;
		int cl = e[0].length;
		int min = e[r][c];
		for(int i = r-1; i < r+1; i ++) {
			for(int j = c-1; j < c+1; j ++) {
				if(i >= 0 && i < rl && j >= 0 && j < cl) {
					min = Math.min(min, e[i][j]);
				}
			}
		}
		if(min == e[r][c])
			m[r][c] = true;
	
		else
			m[r][c] = false;
		return m;
		
	}

}
