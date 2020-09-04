package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/4 3:55 下午
 */
public class DiameterOfBinary543 {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
