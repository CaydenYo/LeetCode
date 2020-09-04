package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/1 11:34 上午
 */
public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> list) {
        if (root.left == null && root.right == null){
            if (sum - root.val == 0){
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }
        list.add(root.val);
        if (root.left != null){
            dfs(root.left, sum - root.val, res, list);
        }
        if (root.right != null){
            dfs(root.right, sum - root.val, res, list);
        }
        list.remove(list.size() - 1);
    }
}
