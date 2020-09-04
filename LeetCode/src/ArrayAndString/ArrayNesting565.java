package ArrayAndString;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/23 9:58 下午
 */
public class ArrayNesting565 {
    public int arrayNesting(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++){
            int count = 0;
            int j = i;
            while (true){
                if (!set.contains(nums[j])){
                    count++;
                    set.add(nums[j]);
                    j = nums[j];
                    if (j >= nums.length || j < 0){
                        break;
                    }
                }else {
                    break;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int arrayNesting1(int[] nums){
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
