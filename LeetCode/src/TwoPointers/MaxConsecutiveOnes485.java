package TwoPointers;

public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 1){
                count++;
            }else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(new MaxConsecutiveOnes485().findMaxConsecutiveOnes(nums));
    }
}
