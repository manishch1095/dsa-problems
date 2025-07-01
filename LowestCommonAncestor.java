public class LowestCommonAncestor {
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