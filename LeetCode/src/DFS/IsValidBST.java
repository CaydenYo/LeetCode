package DFS;

import java.util.Stack;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    // 递归时要注意上下界的问题
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;

        int val = root.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        if (!helper(root.left, lower, val))
            return false;
        if (!helper(root.right, val, upper))
            return false;

        return true;
    }

    /**
     * 使用中序遍历
     * 中序遍历的顺序是左子树->结点->右子树
     * 意味着对于二叉搜索树来说，每个元素都应该比下一个元素小
     * */

    public boolean isValidBSTInorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double lower = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= lower){
                return false;
            }
            lower = root.val;
            root = root.right;
        }
        return true;
    }

}
