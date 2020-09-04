package ArrayAndString;

import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/21 12:24 下午
 */
public class MinimumTotal120 {
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle){
        dfs(triangle, 0, 0, 0);
        return min;
    }

    private void dfs(List<List<Integer>> triangle, int row, int index, int curSum){
        if (row == triangle.size()){
            min = Math.min(min, curSum);
            return;
        }
        dfs(triangle, row + 1, index , curSum + triangle.get(row).get(index));
        dfs(triangle, row + 1, index + 1, curSum + triangle.get(row).get(index));
    }

    /**
     * dp[i][j]代表(i,j)点到底边的最小路径和
     * 则dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
     * */

    public int minimumTotal1(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1;i >= 0;i--){
            for (int j = 0;j <= i;j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 因为每次只用到了下一行的数据
     * 所以我们可以只记录下一行的数据，然后往上进行dp
     * */
    public int minimumTotal2(List<List<Integer>> triangle){
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1;i >= 0;i--){
            for (int j = 0;j <= i;j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
