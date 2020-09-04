package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/25 5:26 下午
 */
public class FindShortestSubArray697 {
    /**
     * 具有度数为d的数组中必须有一些元素x出现d次，
     * 如果某些子数组具有相同的度数d，则其中必须包含元素x
     * 而最短的子数组就是以x第一次出现为开头，以x最后一次出现为结尾的数组
     * 对于给定数组中的每个元素，记录它第一次出现的索引left和最后一次出现的索引right
     * 对于出现次数最多(即d)的每个元素x，其right[x] - left[x] + 1是候选答案，选出其中最小的一个
     * */
    public int findShortestSubArray(int[] nums){
        Map<Integer, Integer> left = new HashMap<>(),
                                right = new HashMap<>(),
                                count = new HashMap<>();
        int degree = 0;
        for (int i = 0;i < nums.length;i++){
            int x = nums[i];
            if (!left.containsKey(x)){
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
            degree = Math.max(degree, count.get(x));
        }

        int ans = nums.length;
        for (int x : count.keySet()){
            if (count.get(x) == degree){
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }

        return ans;
    }

    public int findShortestSubArray1(int[] nums){
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0;
        for (int i = 0;i < nums.length;i++){
            if (!first.containsKey(nums[i])){
                first.put(nums[i], i);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) > degree){
                degree = count.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            }else if (count.get(nums[i]) == degree){
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
