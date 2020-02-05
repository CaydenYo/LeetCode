package BinarySearch;

public class FindMin2 {
    public FindMin2(int[] nums){
        System.out.println(findMin(nums, 0, nums.length - 1, Integer.MAX_VALUE));
    }

    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            // 去掉重复项
            else right = right - 1;
        }
        return nums[left];
    }

    private int findMin(int[] nums, int low, int high, int lowest) {
        if (low == high){
            return nums[low] < lowest ? nums[low] : lowest;
        }
        int mid = (low + high) / 2;
        if (mid != low && nums[low] == nums[mid]){
            low += 1;
            return findMin(nums, low, high, lowest);
        }
        // 二分之后一定有一半有序，对于有序的那一半，下标最小的元素一定是有序组的最小值
        if (nums[low] < nums[mid]){
            if (nums[low] < lowest){
                lowest = nums[low];
            }
            return findMin(nums, mid + 1, high, lowest);
        }else {
            if (nums[mid + 1] < lowest){
                lowest = nums[mid + 1];
            }
            return findMin(nums, low, mid, lowest);
        }
    }



    public static void main(String[] args){
        int[] nums = {2,2,2,0,1};
        new FindMin2(nums);
    }
}
