package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/30 6:08 下午
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
