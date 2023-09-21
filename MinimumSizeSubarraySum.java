class MaximumSizeSubarraySum {
    public static void main(String ... args) throws Exception {
        int[] arr = new int[]{2,3,1,2,4,3};
        MSSS solution = new MSSS();
        System.out.println(solution.solve(arr, 7));
    }
}

 class MSSS {
    public int solve(int[] array, int val) {
        int l = array.length;
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (j = 0; j < l; j++) {
            sum += array[j];
            while(sum >= val) {
                
                ans = Math.min(ans, j - i + 1);
                System.out.println(i + ": " + j + ": " + sum + ":" + ans);
                sum -= array[i++];
            }
        }
       return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}