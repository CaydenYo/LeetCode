package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/26 6:34 下午
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;i++){
            dp[i][i] = nums[i];
            if (dp[i][i] > max){
                max = dp[i][i];
            }
        }

        for (int i = 0;i < nums.length;i++){
            for (int j = i + 1;j < nums.length;j++){
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public int maxSubArray1(int[] nums){
        int max = nums[0];
        int sum = 0;
        for (int num : nums){
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
