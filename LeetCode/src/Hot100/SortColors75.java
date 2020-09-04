package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/28 4:48 下午
 */
public class SortColors75 {
    /**
     * 用三个指针(p0, p2, curr)来分别追踪0的最右边界和2的最左边界和当前考虑的元素
     * 只要0都放左边，2都放右边，剩下的1自然就在中间了
     * */
    public void sortColors(int[] nums){
        int p0 = 0;
        int p2 = nums.length - 1;
        int curr = 0;
        while (curr <= p2){
            if (nums[curr] == 0){
                swap(nums, p0++, curr++);
            }else if (nums[curr] == 2){
                swap(nums, p2--, curr);
            }else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
