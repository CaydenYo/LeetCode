package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int match = target - nums[i];
            if (map.containsKey(match) && map.get(match) != i){
                int[] res = {i, map.get(match)};
                Arrays.sort(res);
                return res;
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(new TwoSum1().twoSum(nums, 9));
    }
}
