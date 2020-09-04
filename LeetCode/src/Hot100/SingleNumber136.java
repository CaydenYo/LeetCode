package Hot100;

import java.util.Arrays;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/1 8:33 下午
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 1;i < nums.length - 1;i++){
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]){
            return nums[nums.length - 1];
        }
        return nums[0];
    }

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数与0异或为任何数 0 ^ n => n
     * 相同的数异或为0: n ^ n => 0
     *
     * [2,3,2,4,4]
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     * */
    public int singleNumber1(int[] nums){
        int single = 0;
        for (int num : nums){
            single ^= num;
        }
        return single;
    }
}
