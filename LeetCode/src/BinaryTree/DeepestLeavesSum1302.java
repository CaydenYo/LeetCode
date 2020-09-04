package BinaryTree;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/13 6:07 下午
 */
public class DeepestLeavesSum1302 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int deepest = -1;
    public int deepestLeavesSum(TreeNode root){
        if (root == null){
            return 0;
        }
        preorder(root, 0);
        int sum = 0;
        List<Integer> list = map.get(deepest);
        for (int i : list){
            sum += i;
        }
        return sum;
    }

    private void preorder(TreeNode root, int depth){
        if (root == null){
            return;
        }
        if (!map.containsKey(depth)){
            map.put(depth, new ArrayList<>());
        }
        map.get(depth).add(root.val);
        deepest = Math.max(deepest, depth);
        preorder(root.left, depth + 1);
        preorder(root.right, depth + 1);
    }


    int sum = 0;
    int max = -1;
    public int deepestLeavesSum1(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }
        // 如果当前节点的深度大于最深的深度就更新深度并且将sum置为当前节点的值
        if(depth > max){
            max = depth;
            sum = root.val;
        }else if(depth == max){
            // 如果当前节点的深度等于最深深度，那么就将它加到结果集
            sum += root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }


    /**
     * 对于每一层都清空sum再计算其总和
     * 遍历结束以后，最终结果只会留下最后一层的结果
     * */
    public int deepestLeavesSum2(TreeNode root){
        if (root == null){
            return 0;
        }
        int num = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            num = 0;
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                num += node.val;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return num;
    }
}
