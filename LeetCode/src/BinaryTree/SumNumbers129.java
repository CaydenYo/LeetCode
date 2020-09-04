package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/1 6:28 下午
 */
public class SumNumbers129 {
    int sum = 0;
    public int sumNumbers(TreeNode root){
        if (root == null){
            return 0;
        }
        dfs(root, root.val);
        return sum;
    }

    private void dfs(TreeNode root, int curSum) {
        if (root.left == null && root.right == null){
            sum += curSum;
            return;
        }
        if (root.left != null){
            dfs(root.left, curSum * 10 + root.left.val);
        }
        if (root.right != null){
            dfs(root.right, curSum * 10 + root.right.val);
        }
    }


    public int sum(TreeNode n, int s){
        if (n == null){
            return 0;
        }
        if (n.left == null && n.right == null){
            return s * 10 + n.val;
        }
        return sum(n.left, s * 10 + n.val) + sum(n.right, s *10 + n.val);
    }
}
