package BinaryTree;

import java.util.ArrayList;

/**
 * @Author cayden
 * @Date 2020/8/11 8:20 下午
 */
public class SumRootToLeaf1022 {
    /**
     * 二进制数每向左移一位等于在原数的基础上乘2(类似于十进制向左移一位等于乘10)
     * 如果此时已经是叶子节点，那么直接将值返回
     * 如果不是就分别递归左右子节点并将最后结果相加返回
     * */
    public int sumRootToLeaf(TreeNode root){
        return preorder(root, 0);
    }

    private int preorder(TreeNode root, int curSum){
        if (root == null){
            return 0;
        }
        curSum = curSum * 2 + root.val;
        if (root.left == null && root.right == null){
            return curSum;
        }
        return preorder(root.left, curSum) + preorder(root.right, curSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        new SumRootToLeaf1022().sumRootToLeaf(root);
    }
}
