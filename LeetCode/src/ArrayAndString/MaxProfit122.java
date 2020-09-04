package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/21 3:30 下午
 */
public class MaxProfit122 {
    // 贪心算法
    public int maxProfit(int[] prices){
        int res = 0;
        int len = prices.length;
        for (int i = 0;i < len - 1;i++){
            res += Math.max(prices[i + 1] - prices[i], 0);
        }
        return res;
    }

    public int maxProfit1(int[] prices){
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // cash：持有现金
        // hold：持有股票
        // 状态数组
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int[] cash = new int[len];
        int[] hold = new int[len];

        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }
}
