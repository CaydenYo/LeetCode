package BinaryTree;

import java.util.HashMap;

/**
 * @Author cayden
 * @Date 2020/8/2 11:22 下午
 */
public class PathSum437 {
    int num = 0;
    public int pathSum(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        count(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return num;
    }

    private void count(TreeNode root, int sum){
        if (root == null){
            return;
        }
        if (sum - root.val == 0){
            num++;
        }
        count(root.left, sum - root.val);
        count(root.right, sum - root.val);
    }


    /**
     * 抵达当前节点(B)后，将前缀和累加，
     * 然后查找在前缀和上有没有前缀和为currSum - target的节点(A)
     * 存在即表示从A到B有一条路劲之和满足条件的情况
     * 递归进入左右子树
     * */
    public int pathSum1(TreeNode root, int sum){
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int curSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null){
            return 0;
        }
        curSum += root.val;
        int res = preSum.getOrDefault(curSum - target, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, target, preSum) + helper(root.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res;
    }
}
