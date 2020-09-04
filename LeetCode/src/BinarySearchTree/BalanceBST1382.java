package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/29 4:50 下午
 */
public class BalanceBST1382 {
    public TreeNode balanceBST(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return balance(list, 0, list.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode balance(List<Integer> list, int low, int high){
        if (low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        int val = list.get(mid);
        TreeNode root = new TreeNode(val);
        root.left = balance(list, low, mid - 1);
        root.right = balance(list, mid + 1, high);

        return root;
    }
}
