package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/24 10:15 下午
 * @Description:
 *      输入：candidates [2,3,6,7], target = 7.
 *      候选数组里有2， 如果找到了 7 - 2 = 5的所有组合，再在之前加上2，就是7的所有组合；
 *      同理考虑3，如果找到了7 - 3 = 4的所有组合，再在之前加上3就是7的所有组合，一次找下去
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if (candidates == null || candidates.length == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(res, cur, candidates, 0, target);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int target){
        for (int i = index;i < candidates.length;i++){
            int curSum = 0;
            for (int j = 0;j < cur.size();j++){
                curSum += cur.get(j);
            }
            if (curSum + candidates[i] == target){
                cur.add(candidates[i]);
                res.add(new ArrayList<>(cur));
                return;
            }else if (curSum + candidates[i] > target){
                cur.remove(cur.size() - 1);
                backtrack(res, cur, candidates, i + 1, target);
            }else {
                cur.add(candidates[index]);
                backtrack(res, cur, candidates, i, target);
            }
        }
    }

    private void dfs(int[] candidates,
                     int residue,
                     int begin,
                     List<Integer> path,
                     List<List<Integer>> res){
        if (residue == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin;i < candidates.length;i++){
            if (residue - candidates[i] < 0){
                break;
            }
            path.add(candidates[i]);
            dfs(candidates, residue - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
