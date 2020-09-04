package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/23 7:22 下午
 */
public class FindDuplicates442 {
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i < nums.length;i++){
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0){
                nums[index - 1] *= -1;
            }else {
                res.add(index);
            }
        }
        return res;
    }
}
