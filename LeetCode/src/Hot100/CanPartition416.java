package Hot100;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/7/12 6:16 下午
 */
public class CanPartition416 {
    /**
     * 由于分两个子集，要让两个子集的和相等
     * 关键点在于求出整个集合的和sum
     * 再将sum除以2得到sum / 2
     * 这个问题就变成了集合中能否找到一个和为sum / 2的子集
     * 接下来就是遍历数组进行DFS，非常基础，必须要掌握
     * 优化：
     * 对数组进行排序，遇到和前一个重复的就跳过
     * */
    public boolean canPartition(int[] nums){
       int sum = 0;
       for (int num : nums){
           sum += num;
       }
       if (sum % 2 != 0){
           return false;
       }
       if (sum == 0){
           return true;
       }
       Arrays.sort(nums);
       return find(nums, sum / 2, 0);
    }

    private boolean find(int[] nums, int sum, int index){
        if (sum == 0){
            return true;
        }
        if (sum < 0){
            return false;
        }
        for (int i = index;i < nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            if (find(nums, sum - nums[i], i + 1)){
                return true;
            }
        }
        return false;
    }


    /**
     * 0-1背包问题
     * 背包问题的描述：
     * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
     * 其中第i个物品的重量为wt[i]，价值为val[i]，现在用这个背包装物品，最多能装的价值是多少。
     * 对于本题可以对集合求和，得出sum然后把问题转化问背包问题：
     * 给一个可装载重量为sum / 2的背包和N个物品，每个物品的重量为nums[i]，是否存在一种装法能够恰好装满背包
     * 1. 状态定义：dp[i][j] = x表示对于前i个物品，当前背包容量为j是，若x为true说明可以恰好装满，否则不能
     *    我们想要的最终答案就是dp[N][sum/2]，base case是dp[..][0] = true和dp[0][..] = false
     *    因为背包没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包
     * 2. 思考状态转移：
     *    如果不把num[i]放进背包里，那么能否恰好装满背包，取决于上一个状态，dp[i - 1][j]
     *    如果装进背包，那么是否能恰好装满背包，取决于dp[i - 1][j - nums[i - 1]]
     *    因为i是从i开始的，而数组索引是从0开始的，所以第i个物品的重量是nums[i - 1]
     *    如果装了第i个物品，就要看背包的剩余重量j - nums[i - 1]限制下能否被恰好装满
     * */
    public boolean canPartition1(int[] nums){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1){
            return false;
        }
        if (sum == 0){
            return true;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0;i <= nums.length;i++){
            dp[i][0] = true;
        }
        for (int i = 0;i <= sum;i++){
            dp[0][i] = false;
        }

        for (int i = 1;i <= nums.length;i++){
            for (int j = 1;j <= sum;j++){
                if (j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        new CanPartition416().canPartition(nums);
    }
}
