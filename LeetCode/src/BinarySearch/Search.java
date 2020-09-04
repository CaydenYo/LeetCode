package BinarySearch;

public class Search {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        if (left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target){
            return mid;
        }else if (nums[mid] > target){
            return binarySearch(nums, left, mid - 1, target);
        }else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }
}
