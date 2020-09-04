package BinaryTree;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/11 1:55 下午
 */
public class VerticalTraversal987 {
    class Node{
        TreeNode node;
        int x;
        int y;
        public Node(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Map<Integer, List<Node>> res_map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();

            min = Math.min(min, node.x);
            max = Math.max(max, node.x);

            if (!res_map.containsKey(node.x)){
                res_map.put(node.x, new ArrayList<>());
            }
            res_map.get(node.x).add(node);

            if (node.node.left != null){
                queue.add(new Node(node.node.left, node.x - 1, node.y - 1));
            }
            if (node.node.right != null){
                queue.add(new Node(node.node.right, node.x + 1, node.y - 1));
            }
        }

        for (int i = min;i <= max;i++){
            Collections.sort(res_map.get(i), new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.y == o2.y){
                        return o1.node.val - o2.node.val;
                    }
                    return 0;
                }
            });

            List<Integer> list = new ArrayList<>();
            for (Node node : res_map.get(i)){
                list.add(node.node.val);
            }
            res.add(list);
        }

        return res;
    }
}
