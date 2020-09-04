package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/6/28 9:26 下午
 */
public class SubSets78 {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for (int i = index;i < nums.length;i++){
            curr.add(nums[i]);
            dfs(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    /**
     * 集合中每个元素的选和不选，构成了一个满二叉状态树，
     * 比如，左子树是不选，右子树是选，从根节点、到叶子节点的所有路径，构成了所有子集。
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。
     * */

    /**
     * DFS，前序遍历
     */
    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<Integer>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，中序遍历
     */
    public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，后序遍历
     */
    public static void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        postOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        postOrder(nums, i + 1, subset, res);
        // 这里
        res.add(subset);
    }


    /**
     * 假设nums=[1,2,3,4]，二进制的0可以写成0000，代表一个数也不取，
     * 1=0001表示去第一个数也就是[1]，
     * 2=0010，表示取第二个数[2]，
     * 3=0011表示取1和2位[1,2]，
     * 4=0100表示[3]....
     * 15=1111表示[1,2,3,4]
     * */
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }

    /**
     * 循环枚举
     */
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    /**
     * 递归枚举
     */
    public static void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<Integer>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        recursion(nums, i + 1, res);
    }

}
