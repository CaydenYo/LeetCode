package ArrayAndString;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Author cayden
 * @Date 2020/8/22 10:16 下午
 */
public class ThirdMax414 {
    public int thirdMax(int[] nums){
        if (nums == null || nums.length == 0) throw new RuntimeException("error");

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) set.remove(set.first());
        }

        return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
    }
}
