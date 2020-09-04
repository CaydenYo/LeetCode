package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/7/31 7:14 下午
 */
public class UniqueBST96 {
    public int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n;i++){
            for (int j = 1;j <= i;j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
