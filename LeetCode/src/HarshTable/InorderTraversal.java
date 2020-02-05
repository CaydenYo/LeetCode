package HarshTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // 递归遍历法
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List <Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    // 迭代遍历法
    public List< Integer > inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList< >();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
