package BFS;

import java.util.*;

public class WidthOfBinaryTree662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 1);
        while (!queue.isEmpty()){
            int min = 0, max = 0;
            int count = queue.size();
            for (int i = 0;i < count;i++){
                TreeNode node = queue.poll();
                int pos = map.get(node);
                map.remove(node);
                if (i == 0){
                    min = pos;
                }
                if (i == count - 1){
                    max = pos;
                }
                if (node.left != null){
                    queue.add(node.left);
                    map.put(node.left, pos * 2 - 1);
                }
                if (node.right != null){
                    queue.add(node.right);
                    map.put(node.right, pos * 2);
                }
            }

            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root = root1;
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root = root.left;
        root.left = new TreeNode(5);
        WidthOfBinaryTree662 wbt = new WidthOfBinaryTree662();
        System.out.println(wbt.widthOfBinaryTree(root1));
    }
}
