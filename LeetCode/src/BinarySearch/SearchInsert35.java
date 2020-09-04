package BinarySearch;

public class SearchInsert35 {
    public SearchInsert35(int[] nums, int target){
        System.out.println(searchInsert(nums, target));
    }

    private int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high){
            mid = (low + high) >> 1;
            if (nums[mid] == target){
                return mid;
            }
            if (target < nums[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }



    public int searchInsert1(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        new SearchInsert35(nums, 7);
    }
}
