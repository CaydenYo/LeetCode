package Hot100;

import org.hamcrest.core.SubstringMatcher;

/**
 * @Author cayden
 * @Date 2020/7/13 5:13 下午
 */
public class FindTargetSumWays494 {
    private int sum = 0;
    public int findTargetSumWays(int[] nums, int S){
        dfs(nums, 0, S);
        return sum;
    }

    private void dfs(int[] nums, int index, int curSum){
        if (index == nums.length && curSum == 0){
            sum += 1;
            return;
        }
        if (index == nums.length){
            return;
        }
        dfs(nums, index + 1, curSum - nums[index]);
        dfs(nums, index + 1, curSum + nums[index]);
    }

    public int findTargetSumWaysDP1(int[] nums, int S){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        // S绝对值范围超过了sum的绝对值范围则不可能得到
        if (Math.abs(S) > Math.abs(sum)){
            return 0;
        }

        int len = nums.length;
        int t = 2 * sum + 1;
        int[][] dp = new int[len][t];
        // 初始化
        if (nums[0] == 0){
            // sum的位置可以看做是0的位置
            dp[0][sum] = 2;
        }else {
            dp[0][sum - nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }

        for (int i = 1;i < len;i++){
            for (int j = 0;j < t;j++){
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }

        return dp[len - 1][sum + S];
    }

    public int findTargetSumWaysDP2(int[] nums, int S){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum + S) % 2 == 1 || S > sum){
            return 0;
        }
        int len = nums.length;
        S = (sum + S) / 2;
        int[][] dp = new int[len + 1][S + 1];
        dp[0][0] = 1;
        for (int i = 1;i <= len;i++){
            if (nums[i - 1] == 0){
                dp[i][0] = dp[i - 1][0] * 2;
            }else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1;i <= S;i++){
            dp[0][i] = 0;
        }
        for (int i = 1;i <= len;i++){
            for (int j = 1;j <= S;j++){
                if (j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return dp[len][S];
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        System.out.println(new FindTargetSumWays494().findTargetSumWaysDP2(nums, 1));
    }
}
