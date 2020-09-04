package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/30 5:23 下午
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root){
        return helper(root, root);
    }

    private boolean helper(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }

        return root1.val == root2.val
                && helper(root1.left, root2.right)
                && helper(root1.right, root2.left);
    }
}
