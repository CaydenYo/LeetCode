package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/14 2:41 下午
 */
public class LongestZigzag1372 {
    int max = 0;
    public int longestZigZag(TreeNode root){
        if (root == null){
            return max;
        }
        dfs(root, true, 0);
        dfs(root, false, 0);
        return max;
    }

    private void dfs(TreeNode root, boolean left, int depth){
        if (root == null){
            return;
        }
        max = Math.max(max, depth);
        if (left){ // 如果当前节点是其父节点的左孩子
            // 搜索当前节点的右孩子，符合zigzag规则，路径长度加1
            dfs(root.right, !left, depth + 1);
            // 搜索当前节点的左孩子，不符合zigzag规则，路径长度重置为1
            dfs(root.left, left, 1);
        }else { // 如果当前节点是其父节点的右孩子
            // 搜索当前节点的左孩子，负责zigzag规则，路径长度加1
            dfs(root.left, !left, depth + 1);
            // 搜索当前节点的右孩子，不符合zigzag规则，路径长度重置为1
            dfs(root.right, left, 1);
        }
    }

    /**
     * res[0]表示当前节点下一步向左走的最大收益，res[1]表示当前节点下一步向右走的最大收益
     * res[0] = 1 + left[1]表示当前节点下一步向左走的最大收益等于左子节点向右走的最大收益 + 1
     * res[1] = 1 + right[0]表示当前节点下一步向右走的最大收益等于右子节点向左走的最大收益 + 1
     * */
    public int longestZigZag1(TreeNode root){
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode root){
        int[] res = new int[2];
        if (root == null){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = 1 + left[1];
        res[1] = 1 + right[0];
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }
}
