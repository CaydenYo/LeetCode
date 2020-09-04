package ArrayAndString;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/24 10:47 上午
 */
public class MaximumProduct628 {
    public int maximumProduct(int[] nums){
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
