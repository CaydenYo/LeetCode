package Hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/7/6 2:26 下午
 */
public class InvertTree226 {
    /**
     * 无论先翻转哪个点，
     * 当递归结束时，root的左子树或者右子树的指针已经发生变化
     * 所以如果我们接着递归得到的结果来获取左子树或者右子树是不对的
     * 我们应该提前保存其中一个子树，当上面递归结束后，再用这个保存好的节点进行递归
     * 这样才能保证获取的子树是正确的
     * */
    public TreeNode invertTree(TreeNode root){
        // 先序遍历 从上向下交换
        if (root == null){
            return null;
        }
        TreeNode node = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(node);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        // 后序遍历-- 从下向上交换
        if (root == null) return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }

    // 层次遍历
    public TreeNode invertTree2(TreeNode root){
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode right = node.right;
            node.right = node.left;
            node.left = right;
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }
}
