package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/9 4:11 下午
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums){
        if (nums != null && nums.length > 1){
            int mark = 0, cur = 0;
            while (cur < nums.length){
                if (nums[cur] == 0){
                    cur += 1;
                }else {
                    int temp = nums[mark];
                    nums[mark] = nums[cur];
                    nums[cur] = temp;
                    cur += 1;
                    mark += 1;
                }
            }
        }
    }
}
