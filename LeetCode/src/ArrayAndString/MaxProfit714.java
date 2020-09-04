package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/25 7:19 下午
 */
public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee){
        int cash = 0, hold = -prices[0];
        for (int i = 1;i < prices.length;i++){
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
