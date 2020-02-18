package Recursion;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return reverseClimbStairs(0, n);
    }

    private int reverseClimbStairs(int i, int n){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }

        return reverseClimbStairs(i + 1, n) + reverseClimbStairs(i + 2, n);
    }

    public int memorization(int i, int n, int[] memo){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }
        if (memo[i] > 0){
            return memo[i];
        }

        memo[i] = memorization(i + 1, n, memo) + memorization(i + 2, n, memo);
        return memo[i];
    }

    public int dynamicProgramming(int n){
        if (n == 1){
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
