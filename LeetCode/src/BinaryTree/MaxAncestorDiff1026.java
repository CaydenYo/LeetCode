package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/12 11:00 上午
 */
public class MaxAncestorDiff1026 {
    int MAX = 0;
    public int maxAncestorDiff(TreeNode root){
        if (root == null){
            return MAX;
        }
        preorder(root, root);
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);
        return MAX;
    }

    private void preorder(TreeNode node, TreeNode ancestor){
        if (node == null || ancestor == null){
            return;
        }
        MAX = Math.max(MAX, Math.abs(ancestor.val - node.val));
        preorder(node.left, ancestor);
        preorder(node.right, ancestor);
    }


    /**
     * 每条从根节点到叶子节点的路径中的最大值和最小值
     * 到达叶子节点求出差值更新全局变量
     * */
    int res = 0;
    public int maxAncestorDiff1(TreeNode root){
        if (root == null){
            return 0;
        }
        helper(root, root.val, root.val);
        return res;
    }

    private void helper(TreeNode root, int max, int min) {
        if (root == null){
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        // 到达叶子节点，求最大差值
        if (root.left == null && root.right == null){
            res = Math.max(res, Math.abs(max - min));
        }
        helper(root.left, max, min);
        helper(root.right, max, min);
    }


}
