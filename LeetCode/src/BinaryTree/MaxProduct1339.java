package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/14 11:43 上午
 */
public class MaxProduct1339 {
    /**
     * 先求出整棵树的总和
     * 另一棵树的和就等于整棵树的总和 - 其中一棵树的和
     * 两棵树的积就等于树i的和 * (整棵树的总和 - 树i的和)
     * 每得到一棵子树的和就套用以上公式，得到的值与最大值比较
     * 遍历完整棵树后可得到最大值
     * */
    long total = 0, res = 0;
    public int maxProduct(TreeNode root){
        total = getSum(root);
        postorder(root);
        return (int)(res % 1000000007);
    }

    private int getSum(TreeNode root){
        if (root == null){
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);
    }

    private int postorder(TreeNode root){
        if (root == null){
            return 0;
        }
        int subSum = root.val + postorder(root.left) + postorder(root.right);
        res = Math.max(res, subSum * (total - subSum));
        return subSum;
    }
}
