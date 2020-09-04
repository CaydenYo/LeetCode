package Hot100;

import java.util.Arrays;

/**
 * @Author cayden
 * @Date 2020/7/14 2:25 下午
 */
public class FindUnsortedSubarray581 {
    /**
     * 从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，记录需要调整的最大位置 i 为 high;
     * 同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.
     * */
    public int findUnsortedSubarray(int[] nums){
        int len = nums.length;
        if(len <= 1) return 0;
        int high = 0, low = len-1, max = nums[0], min = nums[len-1];
        for(int i = 1; i < len; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-1-i]);
            if(nums[i] < max) high = i;
            if(nums[len-1-i] > min) low = len-1-i;
        }
        return high > low ? high - low + 1 : 0;
    }

    /**
     * 排序后一一比较
     * */
    public int findUnsortedSubarray1(int[] nums){
        int[] sorted_array = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sorted_array);
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 <= p2 && sorted_array[p1] == nums[p1]){
            p1 += 1;
        }
        while (p1 <= p2 && sorted_array[p2] == nums[p2]){
            p2 -= 1;
        }

        return p2 - p1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(new FindUnsortedSubarray581().findUnsortedSubarray(nums));
    }
}
