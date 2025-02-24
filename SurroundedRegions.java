public class SurroundedRegions {
    
    public static void main(String[] args) throws Exception {


        char[][] arr = new char[][] {{'X','X','X','X'}
                                    ,{'X','O','O','X'}
                                    ,{'X','X','O','X'}
                                    ,{'X','O','X','X'}};

        Solution solution = new Solution();
        solution.solve(arr);

    }
}

class Solution {

    int[][] surr = new int[][] {{-1,0,1,0}, {0,-1,0,1}}; 

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        if(board.length <= 2 || board[0].length <= 2) {
            return;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length ; j++) {
                if(i == 0 || j == 0 || i == board[i].length - 1 || j == board[i].length - 1) {
                    if( board[i][j] == 'O' && visited[i][j] == false) {
                        // System.out.println("dfs start " + i + " " + j);
                        dfs(i, j, board, visited);
                    }
                }
            }
        }

         for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length ; j++) {
                if(i == 0 || j == 0 || i == board[i].length - 1 || j == board[i].length - 1) {
                    if(board[i][j] == '*'){
                        board[i][j] = 'O';
                    }
                } else {
                    if(board[i][j] == '*') {
                        board[i][j] = 'O';
                    } else if(board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int i, int j, char[][] board, boolean[][] visited ) {
        visited[i][j] = true;

        board[i][j] = '*';

        for(int ifi = 0; ifi < surr.length ; ifi++) {
            for(int ifj = 0; ifj < surr[ifi].length ; ifj++) {
                int newI = i + surr[ifi][ifj];
                int newJ = j + surr[ifi][ifj];
                if(isEligible(newI, newJ, board, visited)) {

                    dfs(newI, newJ, board, visited);
                }
            }
        }

    }
    
    public boolean isEligible(int i, int j, char[][] board, boolean[][] visited) {
        int row_length = board.length;
        int col_length = board[0].length;
        return (i >= 0 && i < row_length - 1) && (j >= 0 && j < col_length - 1) && (board[i][j] == 'O') && visited[i][j] == false;
    }
}
