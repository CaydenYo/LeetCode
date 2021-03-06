package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/13 2:46 下午
 */
public class FindDisappearedNumbers448 {
    /**
     *
     * 找出 1 - n 中没有出现的数字。不能使用额外的空间，两次循环时间复杂度为 2O(n)，即为 O(n)。
     *
     * 解题思路：使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
     *
     * [4,3,2,7,8,2,3,1] 初始数据
     *
     * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
     * [4,3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,-3,1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     *
     * 计算结束，数组的第五个，第六个依然为整数，证明 5,6 没有出现
     */
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i < nums.length;i++){
            nums[Math.abs(nums[i])] = - Math.abs(nums[Math.abs(nums[i])]);
        }

        for (int i = 0;i < nums.length;i++){
            if (nums[i] > 0){
                res.add(i + 1);
            }
        }

        return res;
    }
}
