package ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/20 12:42 下午
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(!hashMap.containsKey(target - nums[i])){
                hashMap.put(nums[i], i);
            }else{
                return new int[]{hashMap.get(target - nums[i]),i};
            }
        }
        return new int[]{};
    }
}
