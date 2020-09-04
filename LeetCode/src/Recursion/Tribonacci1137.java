package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/16 6:08 下午
 */
public class Tribonacci1137 {
    int[] memo;
    public int tribonacci(int n){
        memo = new int[n + 1];

        return helper(n);
    }

    private int helper(int n) {
        if (memo[n] != 0){
            return memo[n];
        }
        if (n == 0){
            memo[n] = 0;
            return memo[n];
        }
        if (n == 1 || n == 2){
            memo[n] = 1;
            return memo[n];
        }
        memo[n] = helper(n - 1) + helper(n - 2) + helper(n - 3);
        return memo[n];
    }

}
