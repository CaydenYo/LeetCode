package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/7 3:08 下午
 */
public class LowestCommonAncestor236 {
    /**
     * 祖先的定义：若节点p在节点root的左(右)子树中，或p = root，则称root是p的祖先
     * 最近公共祖先的定义：设节点root为节点p，q的某公共祖先，
     *                  若其左子节点root.left和右子节点root.right都不是p，q的公共祖先，则称root是最近的公共祖先
     * 根据以上定义，若root是p，q的最近公共祖先，则只可能为一下三种情况之一
     * 1. p和q在root的子树中，且分别在root的左右子树中
     * 2. p == root，且q在root的左或者右子树中
     * 3. q == root，且p在root的左或者右子树中
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null){
            return null;
        }
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}
