package DynamicProgramming;

/**
 * @Author cayden
 * @Date 2020/8/26 6:12 下午
 */
public class MinCostClimbingStairs746 {
    /**
     * 每个元素当前的cost取决于前面是走一步或者走两步
     * 取走一步或者走两步中的最小值
     * 最后的答案则是选择刚好到达最后一个元素还是到达倒数第二个元素后直接跳过最后一个元素
     * */
    public int minCostClimbingStairs(int[] cost){
        int len = cost.length;
        if (len == 2){
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2;i < len;i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(cost));
    }
}
