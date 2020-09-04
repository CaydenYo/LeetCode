package BinarySearchTree;

/**
 * @Author cayden
 * @Date 2020/7/29 10:48 下午
 */
public class MaxSumBST1373 {
    public int maxSumBST(TreeNode root){
        int[] res = {0};
        maxSumBST(res, root);
        return res[0];
    }

    private boolean isBST(TreeNode root, int min, int max){
        if (root == null){
            return true;
        }
        return min < root.val && root.val < max && isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    private void maxSumBST(int[] res, TreeNode root){
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            sumNodeValue(res, root);
            return;
        }
        // 不是BST就递归进入左右子树
        maxSumBST(res, root.left);
        maxSumBST(res, root.right);
    }

    private int sumNodeValue(int[] res, TreeNode node) {
        if (node == null){
            return 0;
        }
        int sum = node.val + sumNodeValue(res, node.left) + sumNodeValue(res, node.right);
        res[0] = Math.max(res[0], sum);
        return sum;
    }
}
