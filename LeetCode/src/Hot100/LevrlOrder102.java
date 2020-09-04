package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/6/30 5:49 下午
 */
public class LevrlOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (count >= 0){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
            res.add(tmp);
        }

        return res;
    }
}
