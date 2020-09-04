package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/9 3:04 下午
 */
public class AllPossibleFBT894 {
    public List<TreeNode> allPossibleFBT(int N){
        List<TreeNode> res = new ArrayList<>();
        if ((N & 1) == 0){
            return res;
        }
        if (N == 1){
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }

        for (int i = 1;i < N;i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
