package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/1 8:41 下午
 */
public class CountNodes222 {
    /**
     * 完全二叉树的高度可以直接通过不断访问左子树就可以获取
     * 判断左右子树的高度：
     * 如果相等则说明左子树是满二叉树，进一步判断右子树的节点数
     * 如果不相等则说明右子树的深度小于左子树的满二叉树，进一步判断左子树的节点数
     * */
    public int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == rh){
            return (1 << lh) + countNodes(root.right);
        }else {
            return (1 << rh) + countNodes(root.left);
        }
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return height(root.left) + 1;
    }
}
