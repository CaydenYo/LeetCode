package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/8 9:08 下午
 */
public class LeafSimilar872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        findLeaf(root1, list1);
        findLeaf(root2, list2);
        if (list1.size() != list2.size()){
            return false;
        }
        for (int i = 0;i < list1.size();i++){
            if (list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void findLeaf(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            list.add(node.val);
            return;
        }
        findLeaf(node.left, list);
        findLeaf(node.right, list);
    }
}
