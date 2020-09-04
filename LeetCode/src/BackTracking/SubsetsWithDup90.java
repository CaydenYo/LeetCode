package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/20 9:30 下午
 */
public class SubsetsWithDup90 {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return res;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, res, new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> res, List<Integer> list){
        if (index == nums.length){
            return;
        }
        for (int i = index;i < nums.length;i++){
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        new SubsetsWithDup90().subsetsWithDup(nums);
    }
}
