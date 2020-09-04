package DFS;

import java.util.LinkedList;
import java.util.Stack;

public class PathSum112 {
    public boolean hasPathSumRecur1(TreeNode root, int sum){
        return helper1(root, 0, sum);
    }
    private boolean helper1(TreeNode root, int cur, int sum){
        if (root == null){
            return false;
        }
        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        }else {
            return helper1(root.left, cur, sum) || helper1(root.right, cur, sum);
        }
    }

    public boolean hasPathSumRecur2(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum - root.val == 0;
        }
        return hasPathSumRecur2(root.left, sum - root.val) || hasPathSumRecur2(root.right, sum - root.val);
    }

    // iterate
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int cur_sum;
        while(!node_stack.isEmpty()){
            node = node_stack.pollLast();
            cur_sum = sum_stack.pollLast();
            if (node.left == null && node.right == null && cur_sum == 0){
                return true;
            }
            if (node.right != null){
                node_stack.add(node.right);
                sum_stack.add(cur_sum - node.right.val);
            }
            if (node.left != null){
                node_stack.add(node.left);
                sum_stack.add(cur_sum - node.left.val);
            }
        }

        return false;
    }


    public boolean hasPathSum1(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum - root.val == 0;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }
}
