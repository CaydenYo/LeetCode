package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/24 11:32 上午
 */
public class SearchRange34 {
    public int[] searchRange(int[] nums, int target){
        if (nums == null || nums.length <= 0){
            return new int[]{-1, -1};
        }
        int pos = binarySearch(nums, 0, nums.length - 1, target);
        if (pos != -1){
            int left = pos, right = pos;
            while (left >= 0){
                if (nums[left] == target){
                    left--;
                }else {
                    break;
                }
            }
            while (right < nums.length){
                if (nums[right] == target){
                    right++;
                }else {
                    break;
                }
            }
            return new int[]{left + 1, right - 1};
        }else {
            return new int[]{-1, -1};
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (right < left){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid] > target){
            return binarySearch(nums, left, mid - 1, target);
        }else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        new SearchRange34().searchRange(nums, 8);
    }
}
