package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/21 7:03 下午
 */
public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return res;
        }
        if (len == 1){
            res.add(nums[0] + "");
            return res;
        }
        int start = 0;
        for (int i = 1;i < len;i++){
            if (nums[i] - 1 > nums[i - 1]){
                if (i - 1 == start){
                    res.add(nums[start] + "");
                }else {
                    res.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        if (start == len - 1){
            res.add(nums[start] + "");
        }else {
            res.add(nums[start] + "->" + nums[len - 1]);
        }

        return res;
    }
}
