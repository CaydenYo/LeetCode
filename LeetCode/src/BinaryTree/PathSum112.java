package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/1 11:04 上午
 */
public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
