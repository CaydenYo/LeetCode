package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/19 5:08 下午
 */
public class TreeSum15 {
    public List<List<Integer>> treeSum(int[] nums){
        List<List<Integer>> ls = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3){
            return ls;
        }
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 2;i++){
            if (nums[i] > 0){
                return ls;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = len - 1, sum = 0 - nums[i];
            while (left < right){
                if (nums[left] + nums[right] == sum){
                    ls.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip duplicated value
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if (nums[left] + nums[right] < sum){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ls;
    }
}
