package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/10 2:38 下午
 */
public class FlipEquiv951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val == root2.val){
            boolean result1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            boolean result2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            return result1 || result2;
        }
        return false;
    }
}
