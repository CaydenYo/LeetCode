package TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public ThreeSumClosest16(int[] nums, int target){
        System.out.println(threeSumClosest(nums, target));
    }

    private int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < nums.length - 2;i++){
            /*
            这里不需要这段代码是因为有可能前面的数非常非常小，
            即使nums[i]大于target再加上两个数依然比前面的数接近target

            if (nums[i] > target){
                return res;
            }*/
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int threeSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - threeSum) < Math.abs(target - res)) {
                    res = threeSum;
                }
                if (threeSum < target){
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }else if (threeSum > target){
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }else {
                    // 已经等于target直接返回
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        new ThreeSumClosest16(nums, target);
    }
}
