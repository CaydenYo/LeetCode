package BinarySearchTree;

import java.util.Stack;

public class LowestCommonAncestor235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        findNode(root, p, ps);
        findNode(root, q, qs);

        TreeNode pn = null;
        TreeNode qn = null;

        while (!ps.isEmpty() && !qs.isEmpty()){

            if (ps.size() > qs.size()){
                pn = ps.pop();
                qn = qs.peek();
            }else if (qs.size() > ps.size()){
                qn = qs.pop();
                pn = ps.peek();
            }else {
                pn = ps.pop();
                qn = qs.pop();
            }

            if (pn.val == qn.val){
                return pn;
            }
        }

        return pn;
    }

    private void findNode(TreeNode root, TreeNode node, Stack<TreeNode> stack){
        if (root.val < node.val){
            stack.push(root);
            findNode(root.right, node, stack);
        }else if (root.val > node.val){
            stack.push(root);
            findNode(root.left, node, stack);
        }else {
            stack.push(root);
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        // p value
        int pVal = p.val;
        // q value
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor1(root.right, p, q);
        }else if (pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor1(root.left, p, q);
        }else {
            // found the split node
            return root;
        }
    }
}
