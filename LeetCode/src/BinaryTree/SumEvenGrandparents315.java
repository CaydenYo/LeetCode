package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/13 2:06 下午
 */
public class SumEvenGrandparents315 {
    public int sumEvenGrandparent(TreeNode root){
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.val % 2 == 0){
            if (root.left != null){
                if (root.left.left != null){
                    res += root.left.left.val;
                }
                if (root.left.right != null){
                    res += root.left.right.val;
                }
            }
            if (root.right != null){
                if (root.right.left != null){
                    res += root.right.left.val;
                }
                if (root.right.right != null){
                    res += root.right.right.val;
                }
            }
        }
        int left = sumEvenGrandparent(root.left);
        int right = sumEvenGrandparent(root.right);

        return res + left + right;
    }
}
