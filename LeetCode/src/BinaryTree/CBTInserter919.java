package BinaryTree;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/8/9 6:47 下午
 */
public class CBTInserter919 {
    private TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter919(TreeNode root) {
        this.root = root;
        deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null){
                deque.offerLast(node);
            }
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null){
            node.left = deque.peekLast();
        }else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
    }




    /**
     * 用列表
     * */
    List<TreeNode> tree;
    public void CBTInserter(TreeNode root){
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0;i < tree.size();i++){
            TreeNode node = tree.get(i);
            if (node.left != null){
                tree.add(node.left);
            }
            if (node.right != null){
                tree.add(node.right);
            }
        }
    }

    public int insert1(int v) {
        int size = tree.size();
        TreeNode node = new TreeNode(v);
        tree.add(node);
        if (size % 2 == 1){
            tree.get((size - 1) / 2).left = node;
        }else {
            tree.get((size - 1) / 2).right = node;
        }
        return tree.get((size - 1) / 2).val;
    }
}
