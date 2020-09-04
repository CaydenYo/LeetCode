package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/10 2:44 下午
 */
public class IsCompleteTree958 {
    public boolean isCompleteTree(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }

        return queue.isEmpty();
    }
}
