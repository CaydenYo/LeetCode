package BinarySearchTree;

import java.util.LinkedList;

public class DeleteInBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        // delete from right subtree
        if (key > root.val){
            root.right = deleteNode(root.right, key);
        }else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }else {
            // the node is a leaf
            if (root.left == null && root.right == null){
                root = null;
            }else if (root.right != null){
                root.val = rightMin(root);
                root.right = deleteNode(root.right, root.val);
            }else {
                // the node is not a leaf, has no right child but has a left child
                root.val = leftMax(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int rightMin(TreeNode root){
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }

    private int leftMax(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }

}
