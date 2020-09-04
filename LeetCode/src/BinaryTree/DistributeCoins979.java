package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/10 9:04 下午
 */
public class DistributeCoins979 {
    /**
     * 理解题目：总共N个节点，N枚金币，因此最后结果每个节点有且只有一枚
     * 如果树的叶子仅包含0枚金币，那么我们需要从它的父节点移动一枚金币到这个叶子节点(此时操作数加1也就是路径加1)
     * 不管此时父节点的金币够不够，反正运行到到最后肯定够
     * 如果一个叶子节点包含大于1数量的金币，那么我们需要将多出来的金币返回给父节点交由父节点去分配
     * 因此返回的数量就是叶子节点金币数量 - 1(给自己保留一枚)
     * 综上所述，对于一个节点，需要移动到它中或者需要从它移动到它父节点的金币数量为Math.abs(num_coins) - 1(即操作数也是路径数)
     * 然后在接下来的计算中，就不需要考虑这些已经考虑过的节点
     * */
    int ans;
    public int distributeCoins(TreeNode root){
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);

        ans += Math.abs(L) + Math.abs(R);

        return root.val + L + R - 1;
    }
}
