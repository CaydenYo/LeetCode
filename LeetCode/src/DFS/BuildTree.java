package DFS;

import java.util.HashMap;

public class BuildTree {
    int pre_index = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map_index = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            map_index.put(val, idx++);
        return helper(0, inorder.length);
    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right){
            return null;
        }

        int root_val = preorder[pre_index];
        TreeNode root = new TreeNode(root_val);
        int index = map_index.get(root_val);
        pre_index++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }
}
