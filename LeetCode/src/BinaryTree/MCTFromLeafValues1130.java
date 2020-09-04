package BinaryTree;

import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/8/13 11:03 上午
 */
public class MCTFromLeafValues1130 {
    /**
     * 数组可以划分为两部分，左边左子树，右边右子树，根节点就是左边最大和右边最大的成绩
     * 首先需要一个二维数组maxValue记录从i到j这几个数中间最大的那个数
     * 然后需要一个二维数组dp来记录从以i到j这几个数可得到的最小代价生成树的值
     * 首先初始化dp数组中的值都为最大，其中对角线的值为0，因为左闭右开对角线内无元素
     * 然后从以长度为1建立最小代价生成树到以长度为len建立最小代价生成树
     * 最后得出完整的最小代价生成树
     * 状态转移方程就是
     * 当前最小代价生成树的总值 = 左边最小代价生成树的总值 + 右边最小代价生成树总值 + 左右子树最大叶子节点值的乘积(得到的是根节点的值)
     * */
    public int mctFromLeafValues(int[] arr){
        int len = arr.length;
        int[][] dp = new int[len][len];
        int[][] maxVal = new int[len][len];
        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                int max = 0;
                for (int k = i;k <= j;k++){
                    if (max < arr[k]){
                        max = arr[k];
                    }
                    maxVal[i][j] = max;
                }
            }
        }
        // 初始化，一开始所有值都趋于最大
        // 对角线初始化为0
        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0;i < len;i++){
            dp[i][i] = 0;
        }
        for (int i = 1;i < len;i++){ // 长度
            for (int j = 0;j < len - i;j++){ // 起始点
                for (int k = j;k < j + i;k++){ // 分割点
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + maxVal[j][k] * maxVal[k + 1][j + i]);
                }
            }
        }
        return dp[0][len - 1];
    }


    public int mctFromLeafValues1(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int n : arr){
            while (stack.peek() < n){
                ans += stack.pop() * Math.min(stack.peek(), n);
            }
            stack.push(n);
        }
        while (stack.size() > 2){
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }
}
