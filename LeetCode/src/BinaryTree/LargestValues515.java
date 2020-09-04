package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/4 3:11 下午
 */
public class LargestValues515 {
    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            int max = Integer.MIN_VALUE;
            while (count > 0){
                TreeNode node = queue.poll();
                if (node.val > max){
                    max = node.val;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
            res.add(max);
        }
        return res;
    }
}
