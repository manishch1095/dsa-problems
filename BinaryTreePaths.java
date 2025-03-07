
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeFromArray(Arrays.asList(1,2,3,null,5), 0);
        Solution solution = new Solution();
        List<String> ans = solution.binaryTreePaths(root);
        for(String s : ans) {
            System.out.println(s);
        }
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
        if (arr == null || arr.size() == 0 || index >= arr.size() || arr.get(index) == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(index));

        root.left = buildTreeFromArray(arr, 2 * index + 1);
        root.right = buildTreeFromArray(arr, 2 * index + 2);

        return root;

    }
}
class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        recurseTree(root, new ArrayList<>());
        return ans;
    }

    void recurseTree(TreeNode root, List<Integer> currPath) {
        if(root == null)
            return;
        currPath.add(root.val);
        if(root.left == null && root.right == null) {
            addToAns(currPath);
        }
        System.out.println("currNode: " + root.val);
        currPath.stream().forEach( x -> System.out.println(x + " "));
        recurseTree(root.left, currPath);
        recurseTree(root.right, currPath);
        currPath.remove(currPath.size() - 1);
    }

    void addToAns(List<Integer> currPath) {
        String s = "";
        for(int i = 0 ; i < currPath.size(); i++) {
            s = s.concat(currPath.get(i).toString());
            if(i != currPath.size() - 1) {
                s = s.concat("->");
            }
        }
        ans.add(s);
    }
}

//https://leetcode.com/problems/binary-tree-paths/submissions/1565989416/?envType=problem-list-v2&envId=backtracking
// learning - concatenation creates extra strings in heap , use stringbuilder for this