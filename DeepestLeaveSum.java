
import java.util.Arrays;
import java.util.List;

public class DeepestLeaveSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTreeFromArray(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8), 0);
        solution.deepestLeavesSum(root);
        System.out.println(solution.sum);
    }
}

class TreeNode {

    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getMaxDepth(TreeNode root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = root.left == null ? 0 :getMaxDepth( root.left);
        int rightDepth = root.right == null ? 0 : getMaxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

class Solution {

    Integer sum = 0;

    public TreeNode buildTreeFromArray(List<Integer> arr, int index) {
        if (arr == null || arr.isEmpty() || index >= arr.size() || arr.get(index) == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(index));

        root.left = buildTreeFromArray(arr, 2 * index + 1);
        root.right = buildTreeFromArray(arr, 2 * index + 2);

        return root;
    }

    public void deepestLeavesSum(TreeNode root) {
        int depth = root.getMaxDepth();
        postOrder(root, depth);
    }

    public void  postOrder(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if(depth == 1) 
            sum += root.val;
        postOrder(root.left, depth - 1);
        postOrder(root.right, depth - 1);
    }
}
