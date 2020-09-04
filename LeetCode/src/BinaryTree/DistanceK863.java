package BinaryTree;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/7 11:56 下午
 */
public class DistanceK863 {
    /**
     * 已知一个节点，那么肯定可以获取它的子节点
     * 如果还有指向父节点的引用，那么就能知道距离该节点1距离的所有节点
     * 之后就可以从target节点开始进行深度优先遍历
     * */
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                if (dist == K){
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode n : queue){
                        ans.add(n.val);
                    }
                    return ans;
                }
                queue.offer(null);
                dist++;
            }else {
                if (!seen.contains(node.left)){
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)){
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)){
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<>();
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (node != null){
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
