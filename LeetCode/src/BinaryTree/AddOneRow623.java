package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/5 12:17 下午
 */
public class AddOneRow623 {
    public TreeNode addOneRow(TreeNode root, int v, int d){
        if (d == 1){
            TreeNode new_root = new TreeNode(v);
            new_root.left = root;
            return new_root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            if (depth >= d){
                break;
            }
            int count = queue.size();
            while (count > 0){
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (depth + 1 == d){
                    node.left = new TreeNode(v);
                    node.left.left = left;

                    node.right = new TreeNode(v);
                    node.right.right = right;
                }
                if (left != null){
                    queue.add(left);
                }
                if (right != null){
                    queue.add(right);
                }
                count--;
            }
            depth++;
        }

        return root;
    }

    public TreeNode addOneRow1(TreeNode root, int v, int d){
        if (d == 0 || d == 1){
            TreeNode new_root = new TreeNode(v);
            if (d == 1) {
                new_root.left = root;
                return new_root;
            }else if (d == 0){
                new_root.right = root;
                return new_root;
            }
        }

        if (root != null && d > 1){
            root.left = addOneRow1(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow1(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            double sum = 0;
            for (int i = 0;i < count;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(sum / count);
            sum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n2.left = n3;

        System.out.println(new AddOneRow623().averageOfLevels(root));
    }
}
