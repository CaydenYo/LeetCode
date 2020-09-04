package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/8/29 11:01 下午
 */
public class GetMaxLen204 {
    public int getMaxLen(int[] nums){
        int max = 0;
        int i = 0;
        while (i < nums.length){
            if (nums[i] == 0){
                i++;
                continue;
            }
            int tmp = 1;
            int length = 0;
            int index = i;
            while (index < nums.length){
                if (nums[index] == 0){
                    break;
                }
                if ((tmp < 0 && nums[index] < 0) || (tmp > 0 && nums[index] > 0)){
                    length = index - i + 1;
                    tmp = 1;
                }else {
                    tmp = -1;
                }
                index++;
            }
            max = Math.max(max, length);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2};
        System.out.println(new GetMaxLen204().getMaxLen(nums));
    }
}
