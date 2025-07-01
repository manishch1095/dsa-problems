import java.util.Arrays;
import java.util.List;

public class Lca {
    public static void main(String[] args) {
        // Print current working directory
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);
        
        TreeNode root = TreeNode.buildTreeFromArray(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4), 0);
        Solution solution = new Solution();
        solution.lowestCommonAncestor(root, root.left.left, root.right.left);
    }
}

class Solution {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findCommonAncestor(root, p, q);
        return ans;
    }

    private boolean findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) 
            return false;

        int mid = (root == p || root == q) ? 1 : 0;
        int leftFound = findCommonAncestor(root.left, p, q) ? 1 : 0;
        int rightFound = findCommonAncestor(root.right, p, q) ? 1 : 0;

        if(mid + leftFound + rightFound >= 2)
            this.ans = root;

       return (mid + leftFound + rightFound > 0);
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

     public static TreeNode buildTreeFromArray(List<Integer> arr, int index) {
        if (arr == null || arr.isEmpty() || index >= arr.size() || arr.get(index) == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(index));

        root.left = buildTreeFromArray(arr, 2 * index + 1);
        root.right = buildTreeFromArray(arr, 2 * index + 2);

        return root;

    }
}

