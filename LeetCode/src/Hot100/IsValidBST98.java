package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cayden
 * @Date 2020/6/30 4:39 下午
 */
public class IsValidBST98 {
    double pre = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.pollLast();
            if (curr.val <= pre){
                return false;
            }else {
                pre = curr.val;
            }
            curr = curr.right;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root){
        if (root == null){
            return true;
        }
        if (!isValidBST1(root.left)){
            return false;
        }
        if (root.val <= pre){
            return false;
        }
        pre = root.val;

        return isValidBST1(root.right);
    }
}
