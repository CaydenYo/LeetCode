package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/8/12 6:49 下午
 */
public class DelNodes1110 {
    /**
     * 因为删除当前节点会对后续的节点产生影响，所以采取后序遍历
     * 在后续遍历中我们先处理叶子节点，再处理父节点，保证了后面删除某一节点时不会影响它的子节点
     * */
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete){
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete){
            set.add(i);
        }
        if (!set.contains(root.val)){
            res.add(root);
        }
        postorder(root, null, set);
        return res;
    }

    private void postorder(TreeNode root, TreeNode parent, Set<Integer> set){
        if (root == null){
            return;
        }
        postorder(root.left, root, set);
        postorder(root.right, root, set);
        if (set.contains(root.val)){
            if (parent != null && parent.left == root){
                parent.left = null;
            }
            if (parent != null && parent.right == root){
                parent.right = null;
            }

            if (root.left != null){
                res.add(root.left);
            }
            if (root.right != null){
                res.add(root.right);
            }
        }
    }
}
