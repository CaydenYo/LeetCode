package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/16 9:09 下午
 */
public class Fib509 {
    int[] memo;
    public int fib(int N){
        memo = new int[N + 1];
        return helper(N);
    }

    private int helper(int N){
        if (N <= 1){
            return N;
        }
        if (memo[N] != 0){
            return memo[N];
        }
        memo[N] = (helper(N - 1) + helper(N - 2)) % 1000000007;
        return memo[N];
    }
}
