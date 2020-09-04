package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/23 6:12 下午
 */
public class Search33 {
    public int search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        if (right < left){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid] > nums[right]){
            if (target >= nums[left] && target < nums[mid]){
                return binarySearch(nums, left, mid - 1, target);
            }else {
                return binarySearch(nums, mid + 1, right, target);
            }
        }else {
            if (target <= nums[right] && target > nums[mid]){
                return binarySearch(nums, mid + 1, right, target);
            }else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }
}
