package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/13 11:01 下午
 */
public class GetTargetCopy1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target){
        if (original == null || original == target){
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null){
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}
