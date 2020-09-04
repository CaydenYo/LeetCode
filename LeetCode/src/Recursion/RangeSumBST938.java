package Recursion;

import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/17 7:56 下午
 */
public class RangeSumBST938 {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R){
        if (root == null){
            return 0;
        }
        helper(root, L, R);
        return sum;
    }

    public void helper(TreeNode root, int L, int R){
        if (root == null){
            return;
        }
        if (root.val >= L){
            helper(root.left, L, R);
        }
        if (root.val >= L && root.val <= R){
            sum += root.val;
        }
        if (root.val <= R){
            helper(root.right, L, R);
        }
    }

    public int rangeSumBST1(TreeNode root, int L, int R){
        if (root == null){
            return 0;
        }

        if (root.val > R){
            // 当前节点大于R就往左边找
            return rangeSumBST1(root.left, L, R);
        }else if (root.val < L){
            // 当前节点小于L就往右边找
            return rangeSumBST1(root.right, L, R);
        }else {
            // 当前节点的值在L和R中间，把自身的值加到结果里，然后往左右子节点递归
            return root.val + rangeSumBST1(root.left, L, R) + rangeSumBST1(root.right, L, R);
        }
    }
}
