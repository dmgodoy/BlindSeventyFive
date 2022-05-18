package blindseventyfive.spiralmatrix;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<>();
		int width = matrix[0].length;
		int height = matrix.length;
		int row = 0;
		int column = 0;

		while (width > 0 && height > 0) {
			if (width == 1 && height == 1) {
				result.add(matrix[row][column]);
				return result;
			}

			int currentRow = row;
			int currentColumn = column;
			// top
			while (currentColumn < column + width)
				result.add(matrix[currentRow][currentColumn++]);

			if (height == 1)
				return result;
			// right
			currentColumn = column + width - 1;
			currentRow = row + 1;
			while (currentRow < row + height - 1)
				result.add(matrix[currentRow++][currentColumn]);

			// bottom
			currentRow = row + height - 1;
			currentColumn = column + width - 1;
			while (currentColumn >= column) {
				result.add(matrix[currentRow][currentColumn--]);
			}
			if (width == 1)
				return result;
			// left
			currentColumn = column;
			currentRow = row + height - 2;
			while (currentRow > row)
				result.add(matrix[currentRow--][currentColumn]);
			
			
			width = width - 2;
			height = height - 2;
			row = row + 1;
			column = column + 1;		
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }).forEach(System.out::println);

	}

}
