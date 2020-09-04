package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/5 6:02 下午
 */
public class FindTarget653 {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k){
        if (root == null){
            return false;
        }
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(k - root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public boolean findTarget1(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int low = 0;
        int high = list.size() - 1;
        while (low < high){
            int sum = list.get(low) + list.get(high);
            if (sum == k){
                return true;
            }else if (sum > k){
                high--;
            }else {
                low++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
