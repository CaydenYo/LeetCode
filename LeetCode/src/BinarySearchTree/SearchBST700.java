package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

public class SearchBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null){
            if (root.val == val){
                return root;
            }else if (root.val > val){
                return searchBST(root.left, val);
            }else {
                return searchBST(root.right, val);
            }
        }
        return null;
    }

    public TreeNode searchBSTIteratively(TreeNode root, int val) {
        while (root != null && val != root.val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
