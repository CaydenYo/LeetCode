package DynamicProgramming;

/**
 * @Author cayden
 * @Date 2020/8/17 2:47 下午
 */
public class FindLength718 {
    public int findLength(int[] A, int[] B){
        if (A == null || B == null){
            return 0;
        }
        int lenA = A.length;
        int lenB = B.length;
        int max = 0;

        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 0;i <= lenA;i++){
            for (int j = 0;j <= lenB;j++){
                if (i != 0 && j != 0){
                    if (A[i - 1] == B[j - 1]){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}
