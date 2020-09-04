package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/27 7:50 下午
 */
public class MinPathSum64 {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // initialize 0 row
        for (int i = 0;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = dp[i][j - 1] + grid[i][j];
            }
        }
        // initialize 0 col
        for (int i = 0;i < n;i++){
            for (int j = 1;j < m;j++){
                dp[j][i] = dp[j - 1][i] + grid[j][i];
            }
        }
        // calculate
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    // 由于本体dp数组和原数组大小一样且每个数据只用一次，因此可以不开额外的空间
    public int minPathSum1(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
