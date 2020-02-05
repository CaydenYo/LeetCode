package DFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {
    // 跪了，这递归太优美了
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 广度优先遍历
    public int BFS(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxLevel = 0;
        while (!queue.isEmpty()){
            maxLevel++;
            for (int i = 0;i < queue.size();i++){
                TreeNode t = queue.poll();
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
            }
        }
        return maxLevel;
    }

    // 深度优先遍历
    public int DFS(TreeNode root){
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, 1));
        int maxDepth = 0;
        //DFS实现前序遍历，每个节点记录其所在深度
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            //DFS过程不断比较更新最大深度
            maxDepth = Math.max(maxDepth, pair.getValue());
            //记录当前节点所在深度
            int curDepth = pair.getValue();
            //当前节点的子节点入栈，同时深度+1
            if (node.right != null) {
                stack.push(new Pair<>(node.right, curDepth + 1));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, curDepth + 1));
            }
        }
        return maxDepth;
    }
}
