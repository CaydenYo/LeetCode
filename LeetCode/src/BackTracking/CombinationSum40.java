package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/20 5:47 下午
 */
public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidate, int index,int target, List<List<Integer>> res, List<Integer> list){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = index;i < candidate.length;i++){
            if (i > index && candidate[i] == candidate[i-1]) continue;
            list.add(candidate[i]);
            backtrack(candidate, i + 1, target - candidate[i], res, list);
            list.remove(list.size() - 1);
        }
    }
}
