package BinarySearch;

public class RotateSearch {
    public RotateSearch(int[] nums, int target){
        System.out.println(search(nums,0, nums.length-1, target));
    }

    // 递归版本
    private int search(int[] nums, int low, int high, int target) {
        if (low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid] < nums[high]){
            if (nums[mid] < target && target <= nums[high]){
                return search(nums, mid + 1, high, target);
            }else {
                return search(nums, low, mid - 1, target);
            }
        }else {
            if (nums[low] <= target && target < nums[mid]){
                return search(nums, low, mid - 1, target);
            }else {
                return search(nums, mid + 1, high, target);
            }
        }
    }

    // 迭代版本
    private int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < nums[high]){
                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }else {
                if (nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
