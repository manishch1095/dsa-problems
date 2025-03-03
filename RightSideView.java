
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,null,5,null,4);
        TreeNode root = TreeNode.makeTree(l, 0);
        TreeNode.inOrder(root);

        System.out.println("----------------");
        Solution solution = new Solution();
        solution.rightSideView(root);
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
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();;
        
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {

            int size = q.size();
            for(int i = 0 ; i < size ; i++ ) {
                TreeNode curr = q.poll();
                if(i == 0) {
                    System.out.println(curr.val);
                }
                if(curr.right != null)
                    q.offer(curr.right);
                if(curr.left != null)
                    q.offer(curr.left);
            }
        }
        return ans;
    }
}