package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/2 10:56 下午
 */
public class SumOfLeftLeaves404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root){
        helper(root);
        return sum;
    }

    private void helper(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            if (root.left.left == null && root.right == null){
                sum += root.left.val;
                return;
            }
        }
        helper(root.left);
        helper(root.right);
    }

    public int sumOfLeftLeaves1(TreeNode root){
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            res = root.left.val;
        }

        return sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right) + res;
    }
}
