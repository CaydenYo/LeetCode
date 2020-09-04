package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/13 10:47 下午
 */
public class RemoveLeafNodes1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target){
        if (root == null){
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
