package ArrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DominantIndex747 {
    public int myDominantIndex(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return -1;
        }
        int index = 0;
        int max = 0;
        for (int i = 0;i < nums.length;i++){
            if (max <= nums[i]){
                max = nums[i];
                index = i;
            }
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] >= 2 * nums[nums.length - 2]){
            return index;
        }
        return -1;
    }

    public int dominantIndex(int[] nums){
        int max = 0;
        int maxIndex = 0;
        int secondMax = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] > max){
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        return max >= 2 * secondMax ? maxIndex : -1;
    }
}
