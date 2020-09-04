package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/7 6:33 下午
 */
public class PruneTree814 {
    public TreeNode pruneTree(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.val == 0 && isAllZero(root)){
            return null;
        }
        if (root.val == 1){
            if (isAllZero(root.left)){
                root.left = null;
            }
            if (isAllZero(root.right)){
                root.right = null;
            }
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    private boolean isAllZero(TreeNode root){
        if (root == null){
            return true;
        }
        if(root.val != 0){
            return false;
        }
        if (isAllZero(root.left) && isAllZero(root.right)){
            return true;
        }
        return false;
    }

    public TreeNode pruneTree1(TreeNode root){
        if (root == null){
            return null;
        }
        root.left = pruneTree1(root.left);
        root.right = pruneTree1(root.right);
        if (root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
