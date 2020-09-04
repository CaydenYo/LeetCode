package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/21 6:49 下午
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, 0, k, n, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int index, int curSum, int k, int n, List<List<Integer>> res, List<Integer> list){
        if (list.size() == k && curSum == n){
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == k){
            return;
        }
        for (int i = index;i <= 9;i++){
            list.add(i);
            backtrack(i + 1, curSum + i, k, n, res, list);
            list.remove(list.size() - 1);
        }
    }
}
