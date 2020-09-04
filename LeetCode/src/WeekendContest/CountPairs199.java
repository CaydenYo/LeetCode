package WeekendContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/25 10:52 下午
 */
public class CountPairs199 {
    int count = 0;
    public int countPairs(TreeNode root, int distance){
        List<TreeNode> leaves = new ArrayList<>();
        findLeaves(root, leaves);

        return count;
    }


    private void findLeaves(TreeNode root, List<TreeNode> leaves){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            leaves.add(root);
        }
        if (root.left != null){
            findLeaves(root.left, leaves);
        }
        if (root.right != null){
            findLeaves(root.right, leaves);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        new CountPairs199().countPairs(root, 1);
    }
}
