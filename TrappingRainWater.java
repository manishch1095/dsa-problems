public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[] {4,2,0,3,2,5}));
    }
}

class Solution {
    public int trap(int[] height) {
        int l = height.length;


        if(l == 0 || l == 1)
            return 0;

        int[] left = new int[l];
        int[] right = new int[l];

        left[0] = 0;
        right[l-1] = 0;
        int max = 0;
        for(int i = 1; i < l; i++) {
            left[i] = max;
            if(height[i] > max) {
                max = height[i];
            }
        }

        max = 0;
        for(int i = l-1 ; i >= 0; i--) {
            right[i] = max;
            if(height[i] > max) {
                max = height[i];
            }
        }

        int sum = 0;
        for(int i = 0 ; i < l ; i++) {
            int up = (Math.min(left[i], right[i]) - height[i]);
            up = up > 0 ? up : 0;
           sum = sum + up;
           System.out.println(sum);
        }
       
        return sum;
    }
}