package HarshTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public TwoSum(int[] nums, int target){
        for (int item : twoSum(nums,target)){
            System.out.println(item);
        };
    }

    private int[] twoSum1(int[] nums, int target){
        int[] tempNums = new int[nums.length * 100];
        for (int i = 0;i < tempNums.length;i++){
            tempNums[i] = -100;
        }
        for (int i = 0;i < nums.length;i++){
            tempNums[nums[i]] = i;
        }
        for (int i = 0;i < nums.length;i++){
            int match = target - nums[i];
            if (tempNums[match] != -100 && tempNums[match] != i){
                int[] res = {i, tempNums[match]};
                Arrays.sort(res);
                return res;
            }
        }
        return new int[]{};
    }
    /*
    两遍哈希表
    private int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            hashMap.put(nums[i], i);
        }
        for (int i = 0;i < nums.length;i++){
            int match = target - nums[i];
            if (hashMap.containsKey(match) && hashMap.get(match) != i){
                return new int[]{i, hashMap.get(match)};
            }
        }
        return new int[]{};
    }
     */

    // 一遍哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int match = target - nums[i];
            if (hashMap.containsKey(match) && hashMap.get(match) != i){
                int[] res = {i, hashMap.get(match)};
                Arrays.sort(res);
                return res;
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        int[] nums = {-3,4,3,90};
        int target = 0;
        new TwoSum(nums, target);
    }
}
