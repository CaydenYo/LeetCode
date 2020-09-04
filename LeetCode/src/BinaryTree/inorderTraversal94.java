package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/31 5:52 下午
 */
public class inorderTraversal94 {
    public List<Integer> inoderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.addLast(node);
                node = node.left;
            }
            node = stack.pollLast();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}
