
import java.util.Arrays;
import java.util.List;

class BstToSumTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTreeFromArray(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8), 0);
        root = solution.bstToGst(root);
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
}

class Solution {

    Integer sum = 0;
    public TreeNode buildTreeFromArray(List<Integer> arr, int index) {
        if (arr == null || arr.size() == 0 || index >= arr.size() || arr.get(index) == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(index));

        root.left = buildTreeFromArray(arr, 2 * index + 1);
        root.right = buildTreeFromArray(arr, 2 * index + 2);

        return root;
    }

    public TreeNode bstToGst(TreeNode root) {
       postOrder(root);
        return root;
    }

    public TreeNode postOrder(TreeNode root) {
        if(root == null)
            return null;

        postOrder(root.right);
        sum += root.val;
        root.val = sum;
        postOrder(root.left);
        return root;
    }
}
