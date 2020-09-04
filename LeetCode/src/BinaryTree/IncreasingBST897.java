package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/9 3:10 下午
 */
public class IncreasingBST897 {
    TreeNode cur = null;
    public TreeNode increasingBST(TreeNode root){
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode node){
        if (node == null){
            return;
        }
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = cur.right;
        inorder(node.right);
    }
}
