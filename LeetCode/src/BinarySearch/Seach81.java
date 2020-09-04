package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/15 1:25 下午
 */
public class Seach81 {
    public boolean search(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return true;
            }
            // 如果出现重复的情况则使用low++去除重复项
            if (nums[low] == nums[mid]){
                low++;
                continue;
            }
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
