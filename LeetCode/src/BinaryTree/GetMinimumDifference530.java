package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/4 3:28 下午
 */
public class GetMinimumDifference530 {
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}
