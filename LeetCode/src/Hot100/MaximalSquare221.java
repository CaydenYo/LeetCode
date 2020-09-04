package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/6 7:15 下午
 */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSize = 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == '1'){
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    maxSize = Math.max(maxSize, dp[i + 1][j + 1]);
                }
            }
        }

        return maxSize * maxSize;
    }

    /**
     * 未优化前的状态定义dp[i][j]，其中i为行，j为列，dp是个二维表格
     * 但是其实每一行只关心上一行，不再关心上上一行，即「从上到下，逐行填写」
     * 由此可优化dp为只留最新的一行，即dp[width + 1](一维，只剩下列数)
     * 但是在填表过程中，会发现缺失了左上角的变量，于是我们需要定义一个变量来储存左上角的值
     * */
    public int maximalSquare1(char[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int width = matrix[0].length;
        int maxSize = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix){
            int northWest = 0;
            for (int col = 0;col < width;col++){
                int nextNorthWest = dp[col + 1];
                if (chars[col] == '1'){
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northWest) + 1;
                    maxSize = Math.max(maxSize, dp[col + 1]);
                }else {
                    dp[col + 1] = 0;
                }
                northWest = nextNorthWest;
            }
        }

        return maxSize * maxSize;
    }
}
