package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/25 5:21 下午
 */
public class Permute46 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> res){
        if (cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (!visited[i]){
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, cur, res);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
