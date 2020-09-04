package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/11 5:49 下午
 */
public class SmallestFromLeaf988 {
    String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return ans;
    }

    private void helper(TreeNode root, String s) {
        if (root == null) return;

        s = (char)('a' + root.val) + s;
        if (root.left == null && root.right == null) {
            String candidate = s;
            if (ans == "" || candidate.compareTo(ans) < 0) {
                ans = candidate;
            }
            return;
        }

        helper(root.left, s);
        helper(root.right, s);
    }
}
