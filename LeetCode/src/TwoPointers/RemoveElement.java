package TwoPointers;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 注意设置两个指针的起始位置
        int i = 0;
        for (int j = 0;j < nums.length;j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 因为没有要求更新后的数组元素顺序
     * 所以可以首尾各一个指针
     * 当我们遇到nums[i] == val时，我们可以将当前元素与最后一个元素交换
     * 并释放最后一个元素
     * */
    public int removeElement1(int[] nums, int val) {
        int head = 0;
        int tail = nums.length;
        while (head < tail){
            if (nums[head] == val){
                nums[head] = nums[tail - 1];
                tail--;
            }else {
                head++;
            }
        }
        return head;
    }
}
