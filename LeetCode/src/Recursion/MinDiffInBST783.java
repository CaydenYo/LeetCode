package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/19 6:44 下午
 */
public class MinDiffInBST783 {
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root){
        helper(root);
        return min;
    }

    private void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        if (prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        helper(root.right);
    }
}
