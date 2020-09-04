package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/6/29 9:21 下午
 */
public class InorderTraversal94 {
    /**
     * 递归做法
     * */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            helper(res, root.left);
        }
        res.add(root.val);
        if (root.right != null){
            helper(res, root.right);
        }
    }

    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.pollLast();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    class ColorNode{
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color){
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Deque<ColorNode> stack = new ArrayDeque<>();
        stack.addLast(new ColorNode(root, "white"));
        while (!stack.isEmpty()){
            ColorNode cn = stack.pollLast();
            if (cn.color.equals("white")){
                if (cn.node.right != null){
                    stack.addLast(new ColorNode(cn.node.right, "white"));
                }
                stack.addLast(new ColorNode(cn.node, "grey"));
                if (cn.node.left != null){
                    stack.addLast(new ColorNode(cn.node.left, "white"));
                }
            }else {
                res.add(cn.node.val);
            }
        }
        return res;
    }
}
