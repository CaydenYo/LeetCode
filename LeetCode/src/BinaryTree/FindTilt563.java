package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/4 6:48 下午
 */
public class FindTilt563 {
    int res = 0;
    public int findTilt(TreeNode root){
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left - right);
        return root.val;
    }
}
