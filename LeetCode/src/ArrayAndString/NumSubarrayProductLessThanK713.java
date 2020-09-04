package ArrayAndString;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/8/25 5:58 下午
 */
public class NumSubarrayProductLessThanK713 {
    /**
     * 暴力法超时
     * */
    public int numSubarrayProductLessThanK(int[] nums, int k){
        int len = nums.length;
        int res = 0;
        for (int i = 0;i < len;i++){
            int product = 1;
            for (int j = i;j < len;j++){
                if (product * nums[j] < k){
                    res += 1;
                    product *= nums[j];
                }else {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 双指针法，如果一个子串的乘积小于k，那么它的每个子集都小于k，
     * 而一个长度为n的数组，它的所有连续子串数量是1+2+...n，但是会和前面的重复。
     * 比如例子中[10, 5, 2, 6]，第一个满足条件的子串是[10]，第二个满足的是[10, 5]，
     * 但是第二个数组的子集[10]和前面的已经重复了，因此我们只需要计算包含最右边的数字的子串数量，就不会重复了，
     * 也就是在计算[10, 5]这个数组的子串是，只加入[5]和[10, 5]，而不加入[10]，这部分的子串数量刚好是r - l + 1
     * */
    public int numSubarrayProductLessThanK1(int[] nums, int k){
        if (k == 0 || k == 1){
            return 0;
        }
        int product = 1; // 储存nums[l]~nums[r]的累积
        int l = 0;
        int res = 0;
        for (int r = 0;r < nums.length;r++){
            product *= nums[r];
            while (product >= k){
                product /= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }
}
