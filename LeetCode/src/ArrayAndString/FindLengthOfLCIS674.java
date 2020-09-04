package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/25 12:01 上午
 */
public class FindLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums){
        int len = nums.length;
        if (nums == null || len == 0){
            return 0;
        }
        int res = 1, cnt = 1;
        for (int i = 1;i < len;i++){
            if (nums[i - 1] < nums[i]){
                res = Math.max(res, ++cnt);
            }else {
                cnt = 1;
            }
        }
        return res;
    }
}
