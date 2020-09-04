package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/13 9:32 下午
 */
public class DiameterOfBinaryTree543 {
    /**
     *
     * 遍历每一个点，以每一个节点为中心点计算最长路径
     * 即计算左子树的最大深度 + 右子树的最大深度
     * 更新全局变量
     * */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        if (root == null){
            return 0;
        }
        maxDepth(root);

        return max;
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 计算左子树 + 右子树
        if (left + right > max){
            max = left + right;
        }
        /**
         * 返回此节点左子树和右子树之中的最大深度
         * 以便作为此节点的父节点的左子树或者右子树的最大深度
         * */
        return Math.max(left, right) + 1;
    }
}
