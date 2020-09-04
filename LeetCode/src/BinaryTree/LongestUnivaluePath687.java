package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/7 1:58 上午
 */
public class LongestUnivaluePath687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root){
        if (root == null){
            return 0;
        }
        length(root, root.val);
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return max;
    }

    public int length(TreeNode root, int val){
        if (root == null || root.val != val){
            return 0;
        }
        int left = length(root.left, val);
        int right = length(root.right, val);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public int longestUnivaluePath1(TreeNode root){
        if (root == null){
            return 0;
        }
        getMaxL(root, root.val);
        return max;
    }

    private int getMaxL(TreeNode root, int val) {
        if (root == null){
            return 0;
        }
        int left = getMaxL(root.left, root.val);
        int right = getMaxL(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == val){
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
