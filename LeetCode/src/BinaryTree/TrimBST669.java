package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/6 9:55 下午
 */
public class TrimBST669 {
    public TreeNode trimBST(TreeNode root, int L, int R){
        if (root == null){
            return null;
        }
        if (root.val < L){
            return trimBST(root.right, L, R);
        }
        if (root.val > R){
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
