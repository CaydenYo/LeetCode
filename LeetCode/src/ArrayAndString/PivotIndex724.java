package ArrayAndString;

import java.util.Arrays;

public class PivotIndex724 {
    public int myPivotIndex(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < nums.length; i++) {
            if (preSum[i - 1] == preSum[nums.length - 1] - preSum[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums){
        int sum = 0;
        int leftSum = 0;
        for (int x : nums){
            sum += x;
        }
        for (int i = 0;i < nums.length;i++){
            if (leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
