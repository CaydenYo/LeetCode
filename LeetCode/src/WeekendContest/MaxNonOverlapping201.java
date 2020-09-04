package WeekendContest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/8 11:11 下午
 */
public class MaxNonOverlapping201 {
    /**
     * 利用set存储每一段的和，若当前位置的和 - target的值存在于set
     * 说明前面存在一段的值等于target
     * 此时res++，然后和重置为0，继续向后查找
     * 这样判断是因为一旦发现前面有符合条件的就加入到结果集能保证所加区间是最短的，保证了最后能找出最多的组合
     * */
    public int maxNonOverlapping(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        int cur = 0, res = 0;
        set.add(0);
        for (int i = 0;i < nums.length;i++){
            cur += nums[i];
            if (set.contains(cur - target)){
                res++;
                cur = 0;
                set.clear();
                set.add(0);
            }else {
                set.add(cur);
            }
        }
        return res;
    }
}
