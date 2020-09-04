package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/7/14 3:22 下午
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

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.addLast(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()){
            TreeNode[] t = stack.pollLast();
            if (t[0] == null || t[1] == null){
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null){
                t[0].left = t[1].left;
            }else {
                stack.addLast(new TreeNode[]{t[0].left, t[1].left});
            }
            if (t[0].right == null){
                t[0].right = t[1].right;
            }else {
                stack.addLast(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
