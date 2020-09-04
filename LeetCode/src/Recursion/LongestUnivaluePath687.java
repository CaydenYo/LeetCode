package Recursion;

/**
 * @Author cayden
 * @Date 2020/7/17 3:47 下午
 */
public class LongestUnivaluePath687 {
    /**
     * 双递归
     * 要么以当前节点往下延伸寻找是否有同值
     * 要么以当前节点的左右子树的根节点往下延伸寻找是否有同值
     * */
    int max = 0;
    public int longestUnivaluePath(TreeNode root){
        if (root == null){
            return 0;
        }
        countSum(root, root.val);
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);

        return max;
    }

    public int countSum(TreeNode root, int target){
        if (root == null || root.val != target){
            return 0;
        }
        int left = countSum(root.left, target);
        int right = countSum(root.right, target);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }


    // 双递归的优化
    int maxLen = 0;
    public int longestUnivaluePath1(TreeNode root) {
        dfs(root, null);
        return maxLen;
    }

    private int dfs(TreeNode root, TreeNode pre) {
        if(root == null) return 0;

        int l = dfs(root.left, root);
        int r = dfs(root.right, root);
        // 对叶子节点来说，长度就是为0，所以0 + 0 = 0
        maxLen = Math.max(maxLen, l+r);

        // 此时我们要返回值给父节点
        // 因此如果这个值等于根的值就返回左右子树较长的一边 + 1作为单边最长路径
        // 返回父节点时相当于向上延伸了一条边
        if(pre != null && pre.val == root.val){
            return Math.max(l, r) + 1;
        }
        return 0;
    }



    int ans;
    public int longestUnivaluePath2(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        // 初始化两边长度均为0
        int arrowLeft = 0, arrowRight = 0;
        // 如果当前节点的左节点的值和当前节点的值一样就在左节点的长度基础上加1
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }
        // 同理
        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }
        /**
         * 如果上述arrowLeft或者arrowRight没有被更新
         * 说明左子树或右子树的根的值和当前节点的值不一样
         * 所以长度就保持原来的0
         * */
        ans = Math.max(ans, arrowLeft + arrowRight);
        // 返回左右子树较长的一边来作为单边最长路径
        return Math.max(arrowLeft, arrowRight);

    }
}
