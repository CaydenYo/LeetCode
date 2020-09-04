package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class Permutstion46 {
    List<List<Integer>> res = new LinkedList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        this.nums = nums;
        boolean[] visited = new boolean[nums.length];
        backtrack(0, visited, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int index, boolean[] visited, LinkedList<Integer> list){
        if (list.size() == nums.length){
            res.add(new LinkedList<>(list));
        }

        for (int i = 0;i < nums.length;i++){
            if (!visited[i]){
                list.addLast(nums[i]);
                visited[i] = true;
                backtrack(i + 1, visited, list);
                list.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        System.out.println(new Permutstion46().permute(nums));
    }
}
