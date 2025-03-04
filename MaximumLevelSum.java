
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSum {
    public static void main(String[] args) {
     List<Integer> l = Arrays.asList(1,7,0,7,-8,null,null);
     TreeNode root = TreeNode.makeTree(l, 0);

     Solution solution = new Solution();
     System.out.println(solution.maxLevelSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static  TreeNode makeTree(List<Integer> arr, int i) {
       TreeNode root = null;

       if(i < arr.size() && arr.get(i) != null) {
           root = new TreeNode(arr.get(i));

           root.left = makeTree(arr, 2*i + 1);
           root.right = makeTree(arr, 2*i + 2);
       }
       return root;
    }

    public static  void inOrder(TreeNode root) {
       
       if(root != null) {
           inOrder(root.left);
           System.out.println(root.val);
           inOrder(root.right);
       }
    }
}


class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null)
        return 0;
    
    int ans = 0;
    int curr_level_sum = 0;
    Queue<TreeNode> q = new LinkedList<>();

    q.offer(root);
    int curr_level = 0;
    int ans_level = 0;
    while(!q.isEmpty()) {
        int size = q.size();
        curr_level++;
        for(int i = 0 ; i < size ; i++ ) {
            TreeNode curr = q.poll();
            curr_level_sum += curr.val;
            if(curr.right != null)
                q.offer(curr.right);
            if(curr.left != null)
                q.offer(curr.left);
        }
        if(curr_level_sum > ans) {
            ans = curr_level_sum;
            ans_level = curr_level;
        }
        curr_level_sum = 0;
    }
    return ans_level;
    }
}