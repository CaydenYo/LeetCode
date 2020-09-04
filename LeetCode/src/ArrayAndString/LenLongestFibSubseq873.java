package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/29 9:24 下午
 */
public class LenLongestFibSubseq873 {
    /**
     * 将斐波那契的子序列中的两个连续相A[i], A[j]视为单个结点
     * 对于对于斐波那契式的子序列 (A[1] = 2, A[2] = 3, A[4] = 5, A[7] = 8, A[10] = 13)，
     * 结点之间的路径为 (1, 2) <-> (2, 4) <-> (4, 7) <-> (7, 10)
     * 只有当A[i] + A[j] == A[k]时，两结点(i,j),(j,k)才算是连通的
     * 设 longest[i, j] 是结束在 [i, j] 的最长路径。
     * 当Map中存在A[i] = A[k] - A[i]时
     * longest[j, k] = longest[i, j] + 1
     * */
    public int lenLongestFibSubseq(int[] A){
        int len = A.length;
        int[][] dp = new int[len - 1][len];
        int maxLen = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < len;i++){
            hashMap.put(A[i], i);
        }

        for (int i = 1;i < len - 1;i++){
            for (int j = i + 1;j < len;j++){
                int ak = A[j] - A[i];
                if (hashMap.containsKey(ak) && hashMap.get(ak) < i){
                    int k = hashMap.get(ak);
                    dp[i][j] = dp[k][i] + 1;
                    maxLen = Math.max(maxLen, dp[i][j] + 2);
                }
            }
        }
        return maxLen;
    }
}
