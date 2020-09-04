package Hot100;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/7/10 5:41 下午
 */
public class CoinChange322 {
    /**
     * 本题的第一直觉是用贪心+回溯
     * 因为想要总硬币数量最少，肯定是优先使用大面值硬币
     * 先丢大硬币，再丢超过总额的时候就递归下一层丢面值较小的硬币(这里我们可以用除法算一下一次最多可以丢多少个)
     * 即k = amount / coins[i]; amount = amount - k *  coins[i]
     * 如果因为丢多了导致最后无法凑出总额再回溯减少大面值硬币
     *
     * 但是要注意因为不是现实中发行的硬币，面值规划不一定合理，所以会有奇葩情况
     * [1,7,10]贪心算法是10+1+1+1+1会被最先找到，然而最优解是7+7
     * 所以还是需要把所有情况递归完
     *
     * 虽然贪心得不到最优解，但是我们可以用贪心得到的结果进行剪枝
     * 关键点就在于要加一个判断条件k + count < ans
     * 如果k + count > ans就没必要递归了
     * */
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount){
        if (amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChange(int[] coins, int amount, int index, int count){
        if (amount == 0){
            ans = Math.min(ans, count);
            return;
        }
        if (index < 0){
            return;
        }
        for (int k = amount / coins[index];k >= 0 && k + count < ans;k--){
            coinChange(coins, amount - k * coins[index], index - 1, count + k);
        }
    }

    /**
     * 动态规划
     * 看题目的问法，只问最优值是多少，没有要我们求最优解，一般情况下就是「动态规划」可以解决的问题；
     * 最优子结构其实比较明显，根据示例1：
     * coins = [1,2,5], amount = 11
     * 凑成面值为11的最小的硬币数可以由以下3者的最小值得到
     * 1. 凑成面值为 10 的最小数 + 面值为 1 的这一枚；
     * 2. 凑成面值为 9 的最小数 + 面值为 2 的这一枚；
     * 3. 凑成面值为 6 的最小数 + 面值为 5 的这一枚；
     * dp[11] = min (dp[10] + 1, dp[9] + 1, dp[6] + 1)
     * dp[amount] = min(1 + dp[amount - coin[i]]) for i in [0, len - 1] if coin[i] <= amount
     * dp[n]的值：表示凑成总金额为n所需的最少的硬币个数
     * */
    public int coinChange1(int[] coins, int amount){
        if (coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount + 1];
        // 面值为amount的硬币最多由amount个1元硬币组成
        // 所以amount + 1这个永远不可能到达的值就相当于无穷大
        for (int i = 1;i < amount + 1;i++){
            dp[i] = amount + 1;
        }
        for (int i = 1;i <= amount;i++){
            for (int coin : coins){
                if (i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,7,10};
        new CoinChange322().coinChange(coins, 14);
    }

}
