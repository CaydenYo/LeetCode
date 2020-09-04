package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/7/1 3:13 下午
 */
public class MaxProfit121 {
    // 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        // 一般初始化为Integer.MAX_VALUE，但是此题最小利润就是为0，所以初始化为0
        int maxProfit = 0;
        for (int i = 0;i < prices.length;i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return minPrice;
    }

    // 因为要赚钱，所以希望股票单调递增
    // 所以可以用到单调栈
    public int maxProfit1(int[] prices){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newPrices = new int[prices.length + 1];
        System.arraycopy(prices, 0, newPrices, 0, prices.length);
        newPrices[prices.length] = -1;
        int maxProfit = 0;
        for (int i = 0;i < newPrices.length;i++){
            while (!stack.isEmpty() && newPrices[i] <= stack.peekLast()){
                int top = stack.pollLast();
                if (stack.isEmpty()){
                    continue;
                }
                maxProfit = Math.max(maxProfit, top - stack.peekFirst());
            }
            stack.addLast(newPrices[i]);
        }
        return maxProfit;
    }
}
