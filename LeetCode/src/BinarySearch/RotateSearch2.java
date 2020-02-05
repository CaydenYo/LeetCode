package BinarySearch;

import java.util.HashSet;
import java.util.Set;

public class RotateSearch2 {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    private boolean search(int[] nums, int low, int high, int target) {
        if (low > high){
            return false;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target){
            return true;
        }
        if (nums[low] < nums[mid]){
            if (nums[low] <= target && target < nums[mid]){
                return search(nums, low, mid - 1, target);
            }else {
                return search(nums, mid + 1, high, target);
            }
        }else {
            if (nums[mid] < target && target <= nums[high]){
                return search(nums, mid + 1, high, target);
            }else {
                return search(nums, low, mid - 1, target);
            }
        }
    }

    private boolean search1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target){
                return true;
            }
            // 如果出现重复的情况则使用low++去除重复项
            if (nums[low] == nums[mid]){
                low++;
                continue;
            }
            // 前半部分有序
            if (nums[low] < nums[mid]){
                if (nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
