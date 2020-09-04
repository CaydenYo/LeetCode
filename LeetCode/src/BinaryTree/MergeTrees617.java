package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/5 1:06 上午
 */
public class MergeTrees617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
