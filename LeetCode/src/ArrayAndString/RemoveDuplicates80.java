package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/20 8:39 下午
 */
public class RemoveDuplicates80 {
    public int removeDuplicates(int[] nums){
        int i = 0;
        for (int num : nums){
            if (i < 2 || num > nums[i - 2]){
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new RemoveDuplicates80().removeDuplicates(nums));
    }
}
