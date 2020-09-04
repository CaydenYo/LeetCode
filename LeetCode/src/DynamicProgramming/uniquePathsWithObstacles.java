package DynamicProgramming;

/**
 * @Author cayden
 * @Date 2020/7/7 11:42 上午
 */
public class uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1){
            return 0;
        }else {
            dp[1][1] = 1;
        }
        for (int i = 1;i < m;i++){
            if (obstacleGrid[i][0] == 0){
                dp[i + 1][1] = dp[i][1] + dp[i + 1][0];
            }else {
                dp[i + 1][1] = 0;
            }
        }
        for (int i = 1;i < n;i++){
            if (obstacleGrid[0][i] == 0){
                dp[1][i + 1] = dp[1][i] + dp[0][i + 1];
            }else {
                dp[1][i + 1] = 0;
            }
        }

        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if (obstacleGrid[i][j] == 0){
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
                }else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }

        return dp[m][n];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        /**
         * 巧妙的循环条件
         * 如果遇到1的话就会直接跳出循环
         * 而不是继续判断i是否小于m
         * 因此1后面的格子也自然都是0
         * */
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
