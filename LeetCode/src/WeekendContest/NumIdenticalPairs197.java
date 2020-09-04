package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/7/11 10:34 下午
 */
public class NumIdenticalPairs197 {
    public int numIdenticalPairs(int[] nums){
        int count = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++){
            for (int j = i + 1;j < n;j++){
                if (nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
