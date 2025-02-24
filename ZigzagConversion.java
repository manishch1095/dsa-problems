

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.convert("PAYPALISHIRING", 4);
    }
    
} 

class Solution {
    public String convert(String s, int numRows) {
        String ans = "";

        int length = s.length();        
        int cnt = 0;

        char[][] rows = new char[length][length];
        
        int i = 0, j = 0;

        while (cnt < length) {

            // System.out.println("----------------------------");
            int m = 0;
            //move downward
            for( ; m < numRows && cnt < length ; m++ ) {
                // System.out.println(m + "," + j + "=" + s.charAt(cnt));
                rows[m][j] = s.charAt(cnt++);
            }

            m = m - 2;
            // move diagnonally upward
            
            // System.out.println("----------------------------" + m);
            while(m > 0 && cnt < length) {
                rows[m--][++j] = s.charAt(cnt);
                // System.out.println(m + "," + j + "=" + s.charAt(cnt));
                cnt++;
            }
            j++;
        }
        return printAns(rows);
       
    }

    String printAns(char[][] ans) {
        String res = "";
        for (int i = 0; i < ans.length; i++) {
            for(int j = 0 ; j < ans[i].length ; j++) {
                if(ans[i][j] != 0) {
                    res += ans[i][j];
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println("");
        }
        return res;
    }
}
