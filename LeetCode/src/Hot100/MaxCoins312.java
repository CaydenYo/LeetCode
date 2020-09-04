package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/15 7:47 下午
 */
public class MaxCoins312 {
    /**
     * 回溯法
     * DFS搜所有组合，取值最大的组合
     * */
    int max = 0;
    public int maxCoins(int[] nums){
        getCoins(nums, 0, 0);
        return max;
    }

    private void getCoins(int[] nums, int idx, int currentCoin){
        int len = nums.length;
        if (idx == len){
            // 如果该路径所得金币数大于当前最大值，就更新最大值
            if (currentCoin > max){
                max = currentCoin;
            }
            return;
        }

        // 尝试所有可走路径
        for (int i = 0;i < len;i++){
            /**
             * 被戳破的气球等于不存在且气球上的数字是大于等于0的，所以将戳破的气球标志位-1
             * 在计算时如果遇到相邻的气球是-1，就略过取相邻下一个气球
             * */
            if (nums[i] == -1){
                continue;
            }
            int temp = nums[i];
            nums[i] = -1;
            // 获取左边的气球的数字
            int before = i - 1;
            int beforeNum = 0;
            while (before > -1 && nums[before] == -1){
                before--;
            }
            // 越界直接赋值为1
            beforeNum = before < 0 ? 1 : nums[before];
            // 获取右边的气球的数字
            int next = i + 1;
            int nextNum = 0;
            while (next < len && nums[next] == -1){
                next++;
            }
            // 越界直接赋值为1
            nextNum = next > len - 1 ? 1 : nums[next];

            // 计算左中右三个数的乘积
            int tempCoin = temp * beforeNum * nextNum;
            // 加上当前的金币数得到累计值后递归下一层
            getCoins(nums, idx + 1, currentCoin + tempCoin);
            // 回溯，将戳破的气球复原
            nums[i] = temp;
        }
    }

    /**
     * 分治
     * 尝试每戳破一个气球，就以该气球为边界将气球数组分为两部分，使用这两部分的解来求解原问题
     * 设戳破区间i到j的气球得到的最大金币数为coin，coin = def(i, j)
     * 则当我们戳破气球k时，两边区间的最大值分别是def(i, k - 1)和def(k + 1, j)
     * 因为戳破了气球 k ，气球数组的相邻关系发生了改变，k-1 与 k+1 原本都与 k 相邻，
     * 而 k 戳破后他们两个直接相邻了。而且先戳破 k+1 与先戳破 k-1 得到的结果将完全不同，也就是说两个子问题间发生了依赖。
     * 如果先戳破 k-1 ，则 k+1 左边的相邻气球变成了 k-2；反之 k-1 右边相邻的气球变成了 k+2 。
     *
     * 因为两个子问题都依赖k和两个边界，那么划分子问题的时候，k与两个边界的气球都不戳破，
     * 求出i + 1到j - 1之间的解，这样子问题间的依赖就被消除了
     * 在两个子问题解决后，气球序列还剩下k与两个边界的气球没有戳破(即虽然以k为分界点，但其实k是最后被戳破的气球)
     * 那么用两个子问题的解与戳破k与两个边界的最大值即可求出原问题的解
     * */
    public int maxCoins1(int[] nums){
        if (nums == null){
            return 0;
        }
        // 加虚拟边界
        int length = nums.length;
        int[] new_nums = new int[length + 2];
        System.arraycopy(nums, 0, new_nums, 1, length);
        new_nums[0] = 1;
        new_nums[length + 1] = 1;
        length = new_nums.length;
        // 创建缓存数组
        int[][] cache = new int[length][length];
        return maxCoins(new_nums, length, 0, length - 1, cache);
    }

    private int maxCoins(int[] new_nums, int length, int begin, int end, int[][] cache) {
        // 回归条件，问题分解到最小子问题
        if (begin == end - 1){
            return 0;
        }
        // 缓存，避免重复计算
        if (cache[begin][end] != 0){
            return cache[begin][end];
        }
        // 维护一个最大值
        int max1 = 0;
        // 状态转移方程 def(i, j) = max(def(i, k) + def(k, j) + nums[i][k][j]), i < k < j
        for (int i = begin + 1;i < end;i++){
            int temp = maxCoins(new_nums, length, begin, i, cache)
                        + maxCoins(new_nums, length, i, end, cache)
                        + new_nums[begin] * new_nums[i] * new_nums[end];
            if (temp > max1){
                max1 = temp;
            }
        }
        cache[begin][end] = max1;
        return max1;
    }

    /**
     * 动态规划
     * */
    public int maxCoins2(int[] nums){
        // 避免空指针异常
        if (nums == null){
            return 0;
        }
        int length = nums.length;
        int[] new_nums = new int[length + 2];
        System.arraycopy(nums, 0, new_nums, 1, length);
        new_nums[0] = 1;
        new_nums[length + 1] = 1;
        length = new_nums.length;

        int[][] dp = new int[length][length];
        for (int i = length - 2;i >= 0;i--){
            for (int j = i + 2;j < length;i++){
                // 维护一个最大值：如果i, j相邻，值为0
                int max = 0;
                for (int k = i + 1;k < j;k++){
                    int temp = dp[i][k] + dp[k][i] + new_nums[i] * new_nums[k] * new_nums[j];
                    if (temp > max){
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length - 1];
    }
}
