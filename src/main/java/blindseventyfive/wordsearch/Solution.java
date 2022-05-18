package blindseventyfive.wordsearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        final int numberOfRows = board.length;
        final int numberOfColumns = board[0].length;
        
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if(findWord(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int start, int row, int column) {
        final int numberOfColumns = board[0].length;
        if(start == word.length())
            return true;
        if(row < 0 || row >= board.length || column < 0 || column >= numberOfColumns)
            return false;
        if((board[row][column] & 256) == 256){ // visited
            return false;
        }
            
        if(word.charAt(start) == board[row][column]){
            board[row][column]^=256; // apply visited mask
            boolean found = findWord(board, word, start + 1, row + 1, column) ||
                    findWord(board, word, start + 1, row - 1, column) ||
                    findWord(board, word, start + 1, row, column + 1) ||
                    findWord(board, word, start + 1, row, column - 1);
            if(!found) //backtrack
                board[row][column]^=256; // remove visited mask
            return found;
        } else {
            return false;
        }
            
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
    }
}