package BinaryTree;

import java.util.HashMap;

public class BuildTree106 {
    private int post_index;
    private int[] inorder;
    private int[] postorder;
    HashMap<Integer, Integer> map_index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_index = postorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        int idx = 0;
        for (Integer val : inorder){
            map_index.put(val, idx++);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right){
            return null;
        }
        int root_val = postorder[post_index--];
        TreeNode root = new TreeNode(root_val);
        int index = map_index.get(root_val);
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }

    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        new BuildTree106().buildTree(inorder, postorder);
    }
}
