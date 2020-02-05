package DFS;

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
}
