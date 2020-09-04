package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/3 11:57 下午
 */
public class FindBottomLeftValue513 {

    /**
     * 从右子树开始层序遍历
     * 最后出队列那个元素肯定就是深度最大且最左边的元素
     * */
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null){
                queue.add(root.right);
            }
            if (root.left != null){
                queue.add(root.left);
            }
        }
        return root.val;
    }

    int max = Integer.MIN_VALUE;
    int res;
    public int findBottomLeftValue1(TreeNode root){
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root != null){
            if (root.left == null && root.right == null){
                if (depth > max){
                    max = depth;
                    res = root.val;
                }
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }

}
