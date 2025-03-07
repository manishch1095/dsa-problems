import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> ans = solution.solveNQueens(4);

        for (List<String> list : ans) {
            for(String row : list) {
                System.out.println(row);
            }
            System.out.println("-----------");
        }
    }
}


class Solution {

    List<List<String>> ans = new ArrayList<>();

    boolean isPlaceable(int row , int col, char[][] board) {
        //check in upper columns
        for(int i = 0 ; i < row; i++) {
            if(board[i][col] == 'Q' )
                return false;
        }

        //check in upper diagonal

        for(int i = row - 1 , j = col - 1; i >=0 && j >=0 ; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        // check in lower diagonal
        for(int i = row - 1, j = col + 1 ; i >= 0 && j < board.length ; i--,j++) {
            if(board[i][j] == 'Q')
                return false;
        }
            
        return true;
    } 


    private void placeQueen(char[][] board, int row) {
        int length = board.length;

        if(row == length) {
            addToAns(board);
            return;
        }

        for(int col = 0 ; col < board.length; col++) {
            if(isPlaceable(row, col , board)) {
                board[row][col] = 'Q';
                placeQueen(board, row+1);
                board[row][col] = '.';
            }
        }
    }
 
    void addToAns(char[][] board) {
        List<String> boardAns = new ArrayList<>();
        for (char[] board1 : board) {
            boardAns.add(new String(board1));
        }
        ans.add(boardAns);
    }

    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0 ; j < n ; j ++) {
                board[i][j] = '.';
            }
        }
        placeQueen(board, 0);
        return ans;
    }
}