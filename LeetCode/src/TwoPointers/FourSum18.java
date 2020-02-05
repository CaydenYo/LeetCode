package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public FourSum18(int[] nums, int target){
        System.out.println(fourSum(nums, target));
    }

    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0;i < len - 3;i++){
            if (i > 0 && nums[i] == nums[i - 1]) // 当i的值与前面的值相等时忽略
                continue;
            /*
            如果target是负数，则nums[i]在负数的时候也可能大于target
            但nums[i]再加上一个负数就有可能小于target，所以不应有此处代码
            if (nums[i] > target)
                break;
             */
            // 获取当前最小值，如果最小值比target大，那后面都比target大，直接结束
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target)
                break;
            // 获取当前最大值，如果最大值比target小，则以i开头的都比target小，跳过此次循环
            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max < target)
                continue;
            for (int j = i + 1;j < len - 2;j++){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1;
                int r = len - 1;
                while (l < r){
                    int fourSum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (fourSum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                        r--;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                    }else if (fourSum < target){
                        l++;
                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                    }else {
                        r--;
                        while (l < r && nums[r] == nums[r + 1])
                            r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        new FourSum18(nums, target);
    }
}
