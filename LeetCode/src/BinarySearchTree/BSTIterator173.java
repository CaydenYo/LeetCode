package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator173 {
    List<Integer> result = new ArrayList<>();
    int index;

    public BSTIterator173(TreeNode root) {
        this.index = -1;
        inorderTraverse(root, result);
    }

    private void inorderTraverse(TreeNode root, List<Integer> result){
//        if (root != null){
//            if (root.left != null){
//                inorderTraverse(root.left, result);
//            }
//            result.add(root.val);
//            if (root.right != null){
//                inorderTraverse(root.right, result);
//            }
//        }
        if (root == null){
            return;
        }
        inorderTraverse(root.left, result);
        this.result.add(root.val);
        inorderTraverse(root.right, result);
    }

    /** @return the next smallest number */
    public int next() {
        return this.result.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (result != null && !result.isEmpty() && index + 1 < result.size()){
            return true;
        }
        return false;
    }
}
