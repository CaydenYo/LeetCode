package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/18 11:25 上午
 */
public class NumWays70 {
    int[] memo;
    public int numWays(int n){
        memo = new int[n + 1];
        return memorization(0, n);
    }

    private int memorization(int i, int n) {
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }
        if (memo[i] > 0){
            return memo[i];
        }

        memo[i] = (memorization(i + 1, n) + memorization(i + 2, n)) % 1000000007;
        return memo[i];
    }


    public int numWays1(int n){
        if (n <= 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n;i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumWays70().numWays(1));
    }
}
