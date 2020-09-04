package Daily;

/**
 * @Author cayden
 * @Date 2020/7/10 12:58 下午
 */
public class MaxProfit09 {
    /**
     * dp状态的选择：
     * 1. 一个三维数组，i表示天，j表示是否持有股票，k表示是否是冷冻期
     * 2. 一个二维数组，dp[i][j]：i表示天，j为0，1，2分别表示持股，不持股，冷冻期
     * 3. 三个一维数组，分别代表第i天，卖出，买进，休息对应的最大收益
     * 4. 两个一维数组，分别表示第i天，持有/没有持有股票的最大收益
     *
     * 以第四点为例，状态转移：
     * 如果持有股票：
     * (1)昨天持有股票，今天休息；(2)前天卖了股票后昨天休息，今天买了股票
     * 如果没有股票：
     * (1)昨天没有股票，今天休息；(2)昨天持有股票，今天卖了
     * */
    public int maxProfit(int[] prices){
        int n = prices.length;
        if (n == 0){
            return 0;
        }
        int[] hold = new int[n];
        int[] unhold = new int[n];
        hold[0] = -prices[0];
        unhold[0] = 0;
        for (int i = 1;i < n;i++){
            if (i == 1){
                hold[i] = Math.max(hold[i - 1], -prices[i]);
            }else {
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            }
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }

        return unhold[n - 1];
    }

    public int maxProfit1(int[] prices){
        int n = prices.length;
        if (n == 0){
            return 0;
        }
        int[] buy = new int[n]; // 在第i天买入的最大收益
        int[] sold = new int[n]; // 在第i天卖出的最大收益
        int[] rest = new int[n]; // 在第i天休息的最大收益

        buy[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1;i < n;i++){
            // 买入的收益情况是：昨天买了，今天没买；昨天因为卖了股票休息了一天，今天买了
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            // 卖出的收益情况是：把之前买的股票卖了
            sold[i] = buy[i - 1] + prices[i];
            // 休息的收益情况是：昨天也休息；昨天卖了股票，今天休息
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }

    public int maxProfit2(int[] prices){
        int n = prices.length;
        if (n == 0){
            return 0;
        }

        // dp[i][0]:手上持有股票的最大收益
        // dp[i][1]:手上没有股票，处于冷冻期的最大收益
        // dp[i][2]:手上没有股票，没有处于冷冻期的最大收益(即可以在当天买入股票)
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1;i < n;i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
