package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                TreeNode t = queue.poll();
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
                if (t.left == null && t.right == null){
                    return level;
                }
                count--;
            }
            level++;
        }
        return level;
    }
}
