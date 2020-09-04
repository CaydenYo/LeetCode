package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p != null && q != null){
            if (p.val != q.val){
                return false;
            }else {
                if (!isSameTree(p.left, q.left)){
                    return false;
                }
                if (!isSameTree(p.right, q.right)){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    // 更优雅的递归
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p != null && q != null && p.val == q.val  ){
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }else {
            return false;
        }
    }

    // iteration version
    public boolean isSameTree2(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (!check(p, q)){
            return false;
        }

        ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();

        deqP.addLast(p);
        deqQ.addLast(q);
        while (!deqP.isEmpty()){
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)){
                return false;
            }
            if (p != null){
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)){
                    return false;
                }
                if (p.left != null){
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)){
                    return false;
                }
                if (p.right != null){
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return true;
    }
}
