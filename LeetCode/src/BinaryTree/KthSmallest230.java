package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/2 11:53 上午
 */
public class KthSmallest230 {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k){
        inorder(root, k);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, int k){
        if (root == null){
            return;
        }
        inorder(root.left, k);
        list.add(root.val);
        if (list.size() == k){
            return;
        }
        inorder(root.right, k);
    }

    /**
     * 查找左子树节点个数为leftN，如果k <= leftN，则所查找节点在左子树上
     * 若k = leftN + 1，则所查节点为根节点
     * 若k > leftN + 1，则所查节点在右子树上，用同样的方法查找右子树的第k - leftN - 1个小的数
     * */
    public int kthSmallest1(TreeNode root, int k){
        int leftN = count(root.left);
        if (k == leftN + 1){
            return root.val;
        }else if (k <= leftN){
            return kthSmallest1(root.left, k);
        }else {
            return kthSmallest1(root.right, k - leftN);
        }
    }

    private int count(TreeNode root){
        if (root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
}
