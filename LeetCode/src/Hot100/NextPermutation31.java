package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/22 6:42 下午
 * @Description:
 *      1. 下一个数比当前数打，只需将后面的"大数"与前面的"小数"交换
 *      2. 下一个数增加的幅度尽可能小：
 *          (1) 在尽可能靠右的低位进行交换，需要从后往前找
 *          (2) 将一个尽可能小的"大数"与前面的交换
 *          (3) 交换后需要将大数后面的所有数字重置为升序，升序排列就是最小排列
 */
public class NextPermutation31 {
    /**
     * 1. 从后向前查找第一个相邻升序的元素对（i，j），A[i] < A[j]。此时[j, end]必然是降序
     * 2. 在[j, end]从后先前查找第一个满足A[i] < A[k]，A[i]就是小数，A[k]是大数
     * 3. 交换A[i]和A[k]
     * 4. 将[j, end]逆置，使其升序
     * 5. 如果在步骤1找不到符合的相邻元素，说明当前[begin, end]为一个降序顺序，直接执行步骤4
     * */
    public void nextPermutation(int[] nums){
        if (nums.length <= 1){
            return;
        }

        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;

        // 找升序元素对
        while (i >= 0 && nums[i] >= nums[j]){
            i--;
            j--;
        }

        if (i >= 0){
            // find nums[i] < nums[k]
            while (nums[i] >= nums[k]){
                k--;
            }
            swap(nums, i, k);
        }

        reverse(nums, j, nums.length - 1);

    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int j, int end){
        while (j < end){
            swap(nums, j++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new NextPermutation31().nextPermutation(nums);
    }
}
