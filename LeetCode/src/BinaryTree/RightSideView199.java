package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/1 6:57 下午
 */
public class RightSideView199 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                TreeNode node = queue.poll();
                if (count == 1){
                    res.add(node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
        }
        return res;
    }

    /**
     * 按照根节点-右子树-左子树的顺序访问，保证每层都是最先访问最右边的节点
     * 先访问当前节点，如果当前节点的深度还没出现在res里，则加入到res中
     * */
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root){
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null){
            return;
        }
        if (depth == res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

}
