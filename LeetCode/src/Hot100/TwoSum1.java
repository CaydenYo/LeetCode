package Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int match = target - nums[i];
            if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) != i) {
                int[] res = {i, hashMap.get(nums[i])};
                Arrays.sort(res);
                return res;
            }
            hashMap.put(match, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 1, 5};
        new TwoSum1().twoSum(nums, 9);
    }
}