package Hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/8 8:11 下午
 */
public class NumSquare279 {
    /**
     * 动态规划：
     * 每个数num的完全平方数都可以被表示为（num - i）+ i，其中i为平方数1, 4, 9, ...
     * 如果我们可以知道(num - i)的这个数是由多少个平方数组成的话，
     * 那么num的完全平方数的个数就是在那个的基础上加上1（也就是i本身）
     * 所以可以得到状态转移方程
     * dp[num] = min(dp[num], dp[num - i] + 1)
     * */
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        for (int i = 1;i <= n;i++){
            // 最坏情况是每次加1的平方
            dp[i] = i;
            for (int j = 1;i - j * j >= 0;j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 贪心算法
     * */
    Set<Integer> square_nums = new HashSet<Integer>();
    protected boolean is_divided_by(int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }

        for (Integer square : square_nums) {
            if (is_divided_by(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public int numSquares1(int n) {
        this.square_nums.clear();

        for (int i = 1; i * i <= n; ++i) {
            this.square_nums.add(i * i);
        }

        int count = 1;
        for (; count <= n; ++count) {
            if (is_divided_by(n, count))
                return count;
        }
        return count;
    }


    /**
     * 贪心算法加bfs
     * */
    public int numSquares2(int n) {

        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
}
