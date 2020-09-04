package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/7/14 10:25 上午
 */
public class SubarraySum560 {
    // brute force
    public int subarraySum(int[] nums, int k){
        int res = 0;
        for (int i = 0;i < nums.length;i++){
            int sum = 0;
            for (int j = i;j < nums.length;j++){
                sum += nums[j];
                if (sum == k){
                    res += 1;
                }
            }
        }
        return res;
    }

    // 前缀和解法(未优化)
    public int subarraySum1(int[] nums, int k){
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int res = 0;
        int preSum = 0;
        for (int i = 0;i < nums.length;i++){
            preSum += nums[i];
            prefixSum[i + 1] = preSum;
        }

        for (int i = 1;i <= nums.length;i++){
            for (int j = 0;j < i;j++){
                if (prefixSum[i] - prefixSum[j] == k){
                    res += 1;
                }
            }
        }

        return res;
    }

    /**
     * 前缀表优化：
     * 因为只关心次数，并不关心解
     * 即不关心下标是从哪到哪
     * 所以用哈希表来记录出现过的前缀和
     * 我们初始化prefixSum[-1] = 0
     * 即把<0, 1>键值对先放到哈希表中
     * 遍历nums的每一项，求当前项的前缀和，存入map中
     * 边存边查看map，如果map中存在key为「当前前缀和 - k」
     * 说明存在「之前出现过的前缀和」，它的值满足「当前前缀和 - 之前出现的前缀和 == k」
     * 把该前缀和出现的次数，累加给count
     * */
    public int subarraySum2(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0;i < nums.length;i++){
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
