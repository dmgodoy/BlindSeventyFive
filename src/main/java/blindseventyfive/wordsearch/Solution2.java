package blindseventyfive.wordsearch;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public boolean exist(char[][] board, String word) {
        final int numberOfRows = board.length;
        final int numberOfColumns = board[0].length;
        
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if(findWord(board, word, 0, i, j, new HashSet<>()))
                    return true;
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int start, int row, int column, Set<Integer> visited) {
        final int numberOfColumns = board[0].length;
        if(start == word.length())
            return true;
        if(visited.contains(row*numberOfColumns + column)){
            return false;
        }
        if(row < 0 || row >= board.length || column < 0 || column >= numberOfColumns)
            return false;
            
        if(word.charAt(start) == board[row][column]){
            visited.add(row * numberOfColumns + column);
            boolean found = findWord(board, word, start + 1, row + 1, column, visited) ||
                    findWord(board, word, start + 1, row - 1, column, visited) ||
                    findWord(board, word, start + 1, row, column + 1, visited) ||
                    findWord(board, word, start + 1, row, column - 1, visited);
            if(!found) //backtrack
                visited.remove(row * numberOfColumns + column);
            return found;
        } else {
            return false;
        }
            
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
    }
}