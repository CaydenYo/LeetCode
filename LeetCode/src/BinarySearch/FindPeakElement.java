package BinarySearch;

public class FindPeakElement {
    public FindPeakElement(int[] nums){
        System.out.println(findPeakElement1(nums, 0, nums.length - 1));
    }

    // 用二分法找出最大值，最大值肯定是峰值
    private int findPeakElement1(int[] nums, int low, int high) {
        if (low == high){
            return low;
        }
        if (low - high == 1){
            return nums[low] >= nums[high]? low : high;
        }
        int index1 = findPeakElement1(nums, low, (low + high)/2);
        int index2 = findPeakElement1(nums, (low + high)/ 2 + 1, high);
        return nums[index1] >= nums[index2]? index1 : index2;
    }

    /**
     * 情况1. 所有的数字以降序排列。这种情况下，第一个元素即为峰值。
     * 我们首先检查当前元素是否大于下个元素。第一个元素满足这一条件，因此被正确判断为峰值。
     * 此时，我们不需要继续向下判断，也就不会有需要判断 nums[i] 和上一个元素 nums[i−1] 的大小的情况
     *
     * 情况2. 所有的数字以升序排列。这种情况下，我们会一直比较 nums[i] 与 nums[i+1]
     * 以判断 nums[i] 是否是峰值元素。没有元素符合这一条件，说明处于上坡而非峰值。
     * 于是，在结尾，我们返回末尾元素作为峰值元素，得到正确结果。
     * 在这种情况下，我们同样不需要比较 nums[i] 和上一个元素nums[i−1]，
     * 因为处于上坡是 nums[i] 不是峰值的充分条件。
     *
     * 情况3. 峰值出现在中间某处。这种情况下，当遍历上升部分时，与情况 2 相同，
     * 没有元素满足 nums[i] > nums[i + 1]。
     * 我们不需要比较 nums[i] 和上一个元素 nums[i-1]。
     * 当到达峰值元素时，nums[i] > nums[i + 1]条件满足。
     * 此时，我们同样不需要比较 nums[i] 和上一个元素 nums[i-1]。
     * 这是由于“遍历会到达第i个元素”本身就说明上一个元素（第i- 1个）不满足 nums[i] > nums[i + 1]nums[i]>nums[i+1] 这一条件，
     * 也就说明 nums[i-1] < nums[i]nums[i−1]<nums[i]。于是，我们同样可以得到正确结果。
    * */
    private int findPeakElement2(int[] nums, int low, int high) {
        if (low == high){
            return low;
        }
        int mid = (low + high) / 2;
        if (nums[mid] > nums[mid + 1]){
            return findPeakElement2(nums, low, mid);
        }
        return findPeakElement2(nums, mid + 1, high);
    }

    // 迭代版本
    private int findPeakElement3(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
