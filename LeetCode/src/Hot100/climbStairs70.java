package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/28 12:41 下午
 */
public class climbStairs70 {
    // 重复计算太多，会超时
    public int climbStairs(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsDP(int n){
        if (n <= 2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3;i <= n;i++){
            int tmp = i1 + i2;
            i1 = i2;
            i2 = tmp;
        }
        return i2;
    }

    public int climbStairsDP1(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
