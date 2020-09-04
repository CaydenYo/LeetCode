package BinaryTree;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/1 12:29 上午
 */
public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = true;
        while (!queue.isEmpty()){
            int count = queue.size();
            int[] tmp = new int[count];
            for (int i = 0;i < count;i++){
                TreeNode node = queue.poll();
                tmp[i] = node.val;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (!isOdd){
                int left = 0, right = tmp.length - 1;
                while (left < right){
                    int temp = tmp[left];
                    tmp[left] = tmp[right];
                    tmp[right] = temp;
                    left++;
                    right--;
                }
            }
            isOdd = !isOdd;
            List<Integer> list = new ArrayList<>();
            for (int item : tmp){
                list.add(item);
            }
            res.add(list);
        }
        return res;
    }
}
