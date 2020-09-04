package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/11 7:08 下午
 */
public class InsertIntoMaxTree998 {
    /**
     * 现在向maximum tree A插入val
     * 如果val比当前的节点的值大，那么它就成为了新的根节点，原来的根节点变成他的左子树
     * 如果val比当前的节点小，因为这个val是插在最后面的，按照leetcode 654题的规则，它应该被插在右子树
     * 于是就要把val往右子树上面插
     * */
    public TreeNode insertIntoMaxTree(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (val > root.val){
            TreeNode new_root = new TreeNode(val);
            new_root.left = root;
            return new_root;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
