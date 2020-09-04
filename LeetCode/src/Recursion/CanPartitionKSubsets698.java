package Recursion;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/7/16 6:31 下午
 */
public class CanPartitionKSubsets698 {
    /**
     * 先算出子集的和是多少，并抽象成k个桶，每个桶的容量是子集的和。
     * 尝试所有不同的组合，如果存在一种组合可以使每个桶都正好放下，那么返回true，否则false
     * */
    public boolean canPartitionKSubsets(int[] nums, int k){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (k > sum || sum % k != 0){
            return false;
        }
        // 子集的和相当于集合的和除以k
        sum /= k;
        // 排序，为后面的贪心算法做准备
        Arrays.sort(nums);
        // 如果子集的和小于数组最大的数直接返回false
        if (nums[nums.length - 1] > sum){
            return false;
        }
        // 建立k个桶，每个桶里的容量是子集和
        int[] buckets = new int[k];
        Arrays.fill(buckets, sum);
        /**
         * 从数组最后一个数(最大值)开始扫描
         * 我们先把大的放进去桶里再用小的填补剩下
         * 如果先放小的，会产生很多种组合，耗费更多时间
         * */
        return dfs(nums, nums.length - 1, buckets, k);
    }

    private boolean dfs(int[] nums, int curr, int[] buckets, int k) {
        /**
         * 只要判断cur < 0就能说明true，而不需要判断一下bucket数组中的值是否全部都是0
         * 因为k个桶的容量和就等于数组里所有元素的和
         * 如果数组里所有元素都能被放进桶里，那就是把所有桶都装满了。
         * */
        if (curr < 0){
            return true;
        }
        /**
         * 对于每一个值而言(nums[curr])
         * 尝试将它放入k个桶里，并找出放入桶里后所产生的所有结果
         * 因为题目只关心能否分成k个子集，所以只要找到一种即可返回true
         * 如果遍历了所有情况都无法找到那就返回false
         * */
        for (int i = 0;i < k;i++){
            if (buckets[i] == nums[curr] || (curr > 0 && buckets[i] - nums[curr] > 0)){
                buckets[i] -= nums[curr];
                if (dfs(nums, curr - 1, buckets, k)){
                    return true;
                }
                // 如果这个数不该放在第i个桶，那就把它拿出来
                buckets[i] += nums[curr];
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        new CanPartitionKSubsets698().canPartitionKSubsets(nums, 4);
    }
}
