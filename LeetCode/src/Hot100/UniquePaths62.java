package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/27 6:04 下午
 * @Description:
 *      这道题是个排列组合问题，因为机器人只能向右或者向下走一步，
 *      所以走到右下角一定要走m + n - 2步，其中一定有m - 1步向右走或者n - 1步向下走
 *      所以直接由公式C(m-1, m+n-2) 或者 C(n-1, m+n-2)可得总路径
 *      但是由于数据过大时会造成溢出，所以要考虑其他办法
 */
public class UniquePaths62 {
    // 用dfs暴力搜索会超时，但是结果是对的
    private int count = 0;
    public int uniquePaths(int m, int n){
        backtrack(1, 1, m, n);
        return count;
    }

    private void backtrack(int curM, int curN, int m, int n){
        if (curM == m && curN == n){
            this.count += 1;
        }
        if (curM + 1 <= m){
            backtrack(curM + 1, curN, m, n);
        }
        if (curN + 1 <= n){
            backtrack(curM, curN + 1, m, n);
        }
    }

    // 用减法会简洁很多，但仍超时
    public int uniquePaths1(int m, int n){
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths1(m - 1, n) + uniquePaths1(m, n - 1);
    }

    /**
     * dp[i][j]是到达i, j的最多路径
     * 动态方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * 对于第一行或者第一列由于都是在边界所以只能为1
     * */
    public int uniquePaths2(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
