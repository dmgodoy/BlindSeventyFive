package blindseventyfive.setmatrixzeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean firstColumnHasZeroes = false;
        boolean firstRowHasZeroes = false;
        
        //check if first column and row have zeroes
        for (int i = 0; i < rows; i++) 
            if(matrix[i][0] == 0)
                firstColumnHasZeroes = true;
        for (int j = 0; j < columns; j++) 
            if(matrix[0][j] == 0)
                firstRowHasZeroes = true;
            
        //set the first element of the row/column to 0 if there is a 0 in the row/column
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < columns; j++)
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        
        //set rows/columns to 0 when the first element is 0
        for (int j = 1; j < columns; j++)
            if(matrix[0][j] == 0)
                setZeroesColumn(matrix, j);
        for (int i = 1; i < rows; i++)
            if(matrix[i][0] == 0)
                setZeroesRow(matrix, i);
        
        //set the first row/column to 0 if there was a zero in the beginning
        if(firstRowHasZeroes)
            setZeroesRow(matrix, 0);
        if(firstColumnHasZeroes)
            setZeroesColumn(matrix, 0);
        
    }

    private void setZeroesColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) 
            matrix[i][column] = 0;        
    }
    private void setZeroesRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) 
            matrix[row][j] = 0;        
    }
    public static void print(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        s.setZeroes(m);
        Solution.print(m);
    }
}
