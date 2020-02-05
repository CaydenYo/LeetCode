package BinarySearch;

public class FindMin {
    public FindMin(int[] nums){
        System.out.println(findMin(nums, 0, nums.length - 1));
    }

    private int findMin(int[] nums, int low, int high) {
        if (low == high){
            return nums[low];
        }
        int mid = (low + high) / 2;
        return Math.min(findMin(nums, low, mid), findMin(nums, mid + 1, high));
    }

    private int findMin(int[] nums, int low, int high, int lowest) {
        if (low == high){
            return nums[low] < lowest ? nums[low] : lowest;
        }
        int mid = (low + high) / 2;
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


    /**
     * 因为是升序数组旋转后的数组，我们需要找到拐点元素
     * 拐点元素必然小于上一个元素，同时因为升序，所以拐点元素就是最小值
     * */
    private int findMin(int[] nums){
        int low = 0, high = nums.length - 1;
        int mid;
        if (high == 0){
            return nums[0];
        }
        if (nums[low] < nums[high]){
            return nums[low];
        }
        while (low < high){
            mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            if (nums[low] < nums[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,1,2,3};
        new FindMin(nums);
    }
}
