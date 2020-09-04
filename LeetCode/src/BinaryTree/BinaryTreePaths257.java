package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/2 4:27 下午
 */
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String s) {
        if (root.left == null && root.right == null){
            s += root.val;
            res.add(s);
            return;
        }
        if (root.left != null){
            dfs(root.left, res, s + root.val + "->");
        }
        if (root.right != null){
            dfs(root.right, res, s + root.val + "->");
        }
    }
}
