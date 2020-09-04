package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/2 9:23 下午
 */
public class Rob337 {
    Map<TreeNode, Integer> hashMap = new HashMap<>();
    public int rob(TreeNode root){
        if (root == null){
            return 0;
        }
        if (hashMap.containsKey(root)){
            return hashMap.get(root);
        }
        int res1 = root.val;
        if (root.left != null){
            res1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            res1 += rob(root.right.left) + rob(root.right.right);
        }
        int res2 = rob(root.left) + rob(root.right);
        int result = Math.max(res1, res2);
        hashMap.put(root, result);
        return result;
    }

    public int rob1(TreeNode root){
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root){
        if (root == null){
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
