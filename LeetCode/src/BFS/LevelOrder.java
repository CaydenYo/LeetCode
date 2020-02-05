package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public LevelOrder(TreeNode root){
        for (List<Integer> item : levelOrder(root)){
            System.out.println(item);
        }
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                TreeNode t = queue.poll();
                list.add(t.val);
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

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0, 1);
        System.out.println(list);
    }
}
