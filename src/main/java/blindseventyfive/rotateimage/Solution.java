package blindseventyfive.rotateimage;


class Solution {
    public void rotate(int[][] matrix) {    	
    	if(matrix.length != matrix[0].length)
    		throw new RuntimeException("Number of rows and columns should be the same.");
    	final int n = matrix.length;
    	for (int d = 0; d < (n - 1)/2 + 1; d++)
    		for (int i = 0 + d; i < n - d - 1; i++) {
				int t = matrix[d][i];
				matrix[d][i] = matrix[n - 1 - i][d];
				matrix[n - 1 - i][d] = matrix[n - 1 - d][n - 1 - i];
				matrix[n - 1 - d][n - 1 - i] = matrix[i][n - 1 - d];
				matrix[i][n - 1 - d] = t;
			}
    }
    public static void print(int[][] m){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++)
				System.out.print(""+m[i][j]+" ");
				
			System.out.println();
		}
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		print(m);
		s.rotate(m);
		System.out.println();
		print(m);
	}
}