package BinarySearchTree;

/**
 * @Author cayden
 * @Date 2020/7/29 4:32 下午
 */
public class BstToGst1038 {
    int rightValue = 0;
    public TreeNode bstToGst(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode right = bstToGst(root.right);
        rightValue += root.val;
        root.val = rightValue;
        bstToGst(root.left);

        return root;
    }
}
