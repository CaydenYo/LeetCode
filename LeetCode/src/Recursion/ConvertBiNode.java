package Recursion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/7/17 11:28 上午
 */
public class ConvertBiNode {
    /**
     * BST中序遍历是有序的，只要对树进行中序遍历，
     * 在这过程中利用一个前驱节点prev，记录上一个被处理的节点，
     * 当前节点被遍历到的时候，将prev.right指向当前节点node
     * node的左子树置空，prev指针后移至node，然后进入node的右子树
     * */
    public TreeNode convertBiNode(TreeNode root){
        TreeNode head = new TreeNode(0);
        helper(root, head);
        return head.right;
    }

    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null){
            return prev;
        }
        prev = helper(root.left, prev);
        root.left = null;
        prev.right = root;
        prev = root;
        prev = helper(root.right, prev);

        return prev;
    }

    public TreeNode convertBiNode1(TreeNode root){
        TreeNode head = new TreeNode(0);
        TreeNode prev = head;

        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.addLast(node);
                node = node.left;
            }else {
                node = stack.pollLast();
                node.left = null;
                prev.right = node;
                prev = node;
                node = node.right;
            }
        }

        return head.right;
    }
}
