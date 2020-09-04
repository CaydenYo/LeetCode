package HarshTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归遍历法
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List <Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    // 迭代遍历法
    public List< Integer > preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList< >();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            if (curr != null){
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode node = stack.pop();
                curr = node.right;
            }
        }
        return res;
    }

    // 深度优先遍历
    public List<Integer> depthOrderTraverse(TreeNode root) {
        List<Integer> res = new ArrayList< >();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    // color
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
            ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
                stack.push(new ColorNode(cn.node,"gray"));
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
    }

}
