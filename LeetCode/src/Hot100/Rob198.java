package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/3 8:09 下午
 */
public class Rob198 {
    /**
     * 对于第i个房屋来说有两种情况
     * 1：偷第i个房屋，那么dp[i] = dp[i - 1] + nums[i]
     * 2：不偷第i个房屋，那么这个房屋的可偷最大金额就等于前一个房屋的最大金额，即dp[i] = dp[i - 1]
     * 我们需要把这两种情况金额较多的情况填入第i个房屋中
     * */
    public int rob(int[] nums){
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,5};
        System.out.println(new Rob198().rob(nums));
    }
}
