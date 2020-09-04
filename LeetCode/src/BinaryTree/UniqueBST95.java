package BinaryTree;

import java.util.LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/31 6:30 下午
 */
public class UniqueBST95 {
    public LinkedList<TreeNode> generateTrees(int n){
        if (n == 0){
            return new LinkedList<>();
        }
        return generate_trees(1, n);
    }

    private LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<>();
        if (start > end){
            all_trees.add(null);
            return all_trees;
        }
        for (int index = start;index <= end;index++){
            LinkedList<TreeNode> left = generate_trees(start, index - 1);
            LinkedList<TreeNode> right = generate_trees(index + 1, end);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode root = new TreeNode(index);
                    root.left = l;
                    root.right = r;
                    all_trees.add(root);
                }
            }
        }
        return all_trees;
    }
}
