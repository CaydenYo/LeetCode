package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/4 3:45 下午
 */
public class ConvertBST538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root){
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}
