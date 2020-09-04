package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/31 7:37 下午
 */
public class IsValidBST98 {
    public boolean isValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (prev != null && root.val <= prev.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}
