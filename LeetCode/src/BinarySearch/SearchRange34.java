package BinarySearch;

public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0){
            return res;
        }
        int left = findLeft(nums, target);
        if(nums[left] != target){
            return res;
        }
        int right = findRight(nums, target);
        res[0] = left;
        res[1] = right;
        return res;
    }

    private int findLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target || nums[mid] == target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int findRight(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target || nums[mid] == target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        new SearchRange34().searchRange(nums,target);
    }
}
