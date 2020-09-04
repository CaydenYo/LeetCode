package TwoPointers;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum15 {
    public ThreeSum15(int[] nums){
        System.out.println(threeSum(nums).toString());
    }

    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3){
            return ls;
        }
        Arrays.sort(nums);// 排序

        for (int i = 0; i < len - 2; i++) { // 一次加三个数，len-2为了不出边界
            if (nums[i] > 0){
                return ls;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue; // 跳过可能重复的答案
            }


            int l = i + 1, r = len - 1, sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }

        }
        return ls;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new ThreeSum15(nums);
    }
}
