package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    public IsSymmetric(TreeNode root){
        System.out.println(isSymmetric(root, root));
    }

    // 递归
    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val)
                && isSymmetric(t1.left, t2.right)
                && isSymmetric(t1.right, t2.left);
    }

    // 迭代
    private boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null){
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }
            if (t1.val != t2.val){
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
