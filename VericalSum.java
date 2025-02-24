import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class VericalSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTreeFromArray(Arrays.asList(3,9,20,null,null,15,7), 0);
        System.out.println(solution.verticalOrder(root));
            
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

    SortedMap<Integer, List<Integer>> result = new TreeMap<>();


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        inOrderTraversal(root, 0);
        for(Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            List<Integer> values = new ArrayList();
            entry.getValue().forEach(x -> {
                values.add(x);
            });
            ans.add(values);
        }
        return ans;
    }

    public TreeNode buildTreeFromArray(List<Integer> arr, int index) {
        if (arr == null || arr.isEmpty() || index >= arr.size() || arr.get(index) == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(index));

        root.left = buildTreeFromArray(arr, 2 * index + 1);
        root.right = buildTreeFromArray(arr, 2 * index + 2);

        return root;
    }

    public void inOrderTraversal(TreeNode root, int index) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, index - 1);
        result.computeIfAbsent(index, k -> new ArrayList<>()).add(root.val);
        inOrderTraversal(root.right, index + 1);
    }
}
