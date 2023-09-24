import java.util.Arrays;

public class LeftRightSumDifferences {
    public static void main(String[] args) {
        LeftRight leftRight = new LeftRight();
        int[] ans = leftRight.solve(new int[]{10,4,8,3});
        System.out.println(Arrays.toString(ans));
    }

    public static class LeftRight {

        public int[] solve(int[] x) {
            int totalSum = 0;
            int[] answer = new int[x.length];
            for (int i = 0; i < x.length; i++) {
                totalSum += x[i];
            }
            int leftSum = 0;
            int right = 0;
            for(int i = 0; i < x.length; i++) {
                right = totalSum - x[i];
                answer[i] = Math.abs(leftSum - right);
                leftSum += x[i];
                totalSum -= x[i];
            }
            return answer;
        }
    }
}
