package HarshTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    /**
     * 接下来我们思考一下前序遍历和后序遍历之间的关系：
     *
     * 前序遍历顺序为：根 -> 左 -> 右
     *
     * 后序遍历顺序为：左 -> 右 -> 根
     *
     * 如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，修改为将节点插入结果链表的头部
     *
     * 那么结果链表就变为了：右 -> 左 -> 根
     *
     * 如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
     *
     * 那么结果链表就变为了：左 -> 右 -> 根
     *
     * 这刚好是后序遍历的顺序
     * */
    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                output.addFirst(root.val);
                root = root.right;
            }else {
                root = stack.pop();
                root = root.left;
            }
        }
        return output;
    }


    // color method
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
           ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
    }
}
