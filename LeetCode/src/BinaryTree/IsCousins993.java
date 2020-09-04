package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/11 12:50 上午
 */
public class IsCousins993 {
    /**
     * 首先DFS得到两个节点的深度，如果两个节点的深度不一样直接返回false
     * 如果深度一样表示这两个点在同一层，然后寻找这两个节点的父节点
     * 如果父节点一样返回false，否则返回true
     * */
    public boolean isCousins(TreeNode root, int x, int y) {
        int depthX = getDepth(root, x, 0);
        int depthY = getDepth(root, y, 0);
        if (depthX != depthY){
            return false;
        }
        TreeNode px = getParent(root, x, null);
        TreeNode py = getParent(root, y, null);
        return depthX == depthY;
    }

    public int getDepth(TreeNode root, int x, int depth) {
        if(root == null) return 0;
        if(root.val == x) {
            return depth;
        }
        int leftD = getDepth(root.left, x, depth + 1);
        int rightD = getDepth(root.right, x, depth + 1);
        if(leftD != 0) return leftD;
        if(rightD != 0) return rightD;
        return 0;
    }

    public TreeNode getParent(TreeNode root, int x, TreeNode parent) {
        if(root == null) return null;
        if(root.val == x) {
            return parent;
        }
        TreeNode leftP = getParent(root.left, x, root);
        TreeNode rightP = getParent(root.right, x, root);
        if(leftP != null) return leftP;
        if(rightP != null) return rightP;
        return null;
    }

    /**
     * 用BFS遍历树
     * 对于同一层的节点首先判断是否是x或y
     * 然后再对每一个节点判断它是否同时是x和y的父节点
     * 如果是返回false，否则入队
     * */
    public boolean isCousins1(TreeNode root, int x, int y){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.val == x){
                    isAexist = true;
                }
                if (node.val == y){
                    isBexist = true;
                }
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) {
                        return false;
                    }
                    if (node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            if (isAexist && isBexist){
                return true;
            }
            if (isAexist || isBexist){
                return false;
            }
        }
        return false;
    }
}
