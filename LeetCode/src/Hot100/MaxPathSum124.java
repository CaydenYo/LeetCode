package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/1 6:31 下午
 */

/**
 * 用最基础的二叉树abc来理解
 * 可能产生的情况有三种
 * b + a + c
 * b + a + a的父节点
 * c + a + a的父节点
 *
 * 其中情况1表示不联络a的父节点，这种情况是没办法递归的，
 * 而且其答案有可能就是最佳，因此我们可以将得到的答案直接与全局的最大值作比较并更新
 * 对于情况2和3，我们在递归的时候要计算a + b和a + c并且在两者之间选择更优的情况加上a本身的值返回给a的父节点
 * */
public class MaxPathSum124 {
    private int maxPathSum = Integer.MIN_VALUE;

    public int getMaxPathSum(TreeNode root){
        if (root == null){
            return 0;
        }
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        // 这里用0作为参考的原因是，如果任何一个分支为负数，那还不如不选择
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 情况1，直接将b + a + c与最大值作比较
        maxPathSum = Math.max(maxPathSum, left + root.val + right);
        // 将左分支和右分支更好的一条分支加上a本身返回给a的父节点
        return root.val + Math.max(left, right);
    }
}
