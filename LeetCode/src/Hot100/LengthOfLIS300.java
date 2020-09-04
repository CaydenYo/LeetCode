package Hot100;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/7/9 8:15 下午
 */
public class LengthOfLIS300 {
    /**
     * 将状态定义成：dp[i]表示以nums[i]结尾的最长上升子序的长度
     * 关键点在于，一个数有可能和前面的多个数组成多个上升子序
     * 所以需要把下标i之前的所有数都看一遍
     * 只要nums[i]严格大于在它位置之前的某个数，那么nums[i]就可以接在这个数后面形成新的上升子序
     * 状态数组dp的最大值才是最后要输出的值
     * */
    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1;i < len;i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0;i < len;i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划 + 二分查找
     * 1. 动态规划中，通过线性遍历来极端dp的复杂度无法降低
     * 2. 每轮计算中，需要通过线性遍历[0, k)区间元素来得到dp[k]。
     * 如果重新设计状态定义，使整个dp为一个排序列表，这样在计算每个dp[k]是，就可以通过二分法遍历[0, k)
     * */
    public int lengthOfLIS1(int[] nums){
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums){
            int i = 0, j = res;
            while (i < j){
                int m = i + (j - i) / 2;
                if (tails[m] < num){
                    i = m + 1;
                }else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j){
                res++;
            }
        }
        return res;
    }
}
