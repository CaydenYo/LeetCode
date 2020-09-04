package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * we can't stop recursion
 * so we need to use stack to control inorder traverse
 * */
public class BetterBSTIterator173 {
    LinkedList<TreeNode> stack = new LinkedList<>();


    public BetterBSTIterator173(TreeNode root) {
        leftMostInorder(root);
    }

    private void leftMostInorder(TreeNode root){
        while (root != null){
            this.stack.addFirst(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        // node at the top of the stack is the next smallest element
        TreeNode node = this.stack.poll();
        if (node.right != null){
            leftMostInorder(node.right);
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
