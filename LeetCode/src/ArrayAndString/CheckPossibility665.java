package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/7/19 7:27 下午
 */
public class CheckPossibility665 {
    /**
     * 如果出现a[i] < a[i - 1]  改变一个数就面临两种选择
     * 1. 把a[i]变大
     * 2. 把a[i - 1]变小
     * ... 1 4 3 ...   只能选择把4变小   ... 3 4 1 ... 只能选择把1变大
     * 既然是需要修改的数，那么我们就先把它修改掉
     * 如果修改后的数组仍需要修改那就证明不可能通过改变一个元素达到题目目的
     * */
    public boolean checkPossibility(int[] nums){
        int n = nums.length;
        if (n == 0 || n == 1){
            return true;
        }
        int count = 0;
        for (int i = 1;i < n;i++){
            if (nums[i] > nums[i - 1]){
                continue;
            }
            if (i - 2 >= 0 && nums[i] < nums[i - 2]){
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
