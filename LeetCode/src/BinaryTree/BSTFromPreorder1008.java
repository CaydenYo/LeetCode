package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/11 8:02 下午
 */
public class BSTFromPreorder1008 {
    public TreeNode bstFromPreorder(int[] preorder){
        if (preorder == null || preorder.length == 0){
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int low, int high){
        if (low > high){
            return null;
        }

        int val = preorder[low];
        TreeNode root = new TreeNode(val);
        int i = low + 1;
        for (;i <= high;i++){
            if (preorder[i] > val){
                break;
            }
        }
        root.left = buildTree(preorder, low + 1, i - 1);
        root.right = buildTree(preorder, i, high);

        return root;
    }
}
