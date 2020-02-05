package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                TreeNode t = queue.poll();
                // res.size() % 2 == 1时说明目前已插入奇数层，下一层是偶数
                if (res.size() % 2 == 1){
                    list.add(0, t.val);
                }else {
                    list.add(t.val);
                }
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
