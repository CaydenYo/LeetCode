package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/6 10:41 下午
 */
public class FindSecondMinimumValue671 {
    public int findSecondMinimumValue(TreeNode root){
        if (root == null){
            return -1;
        }
        if (root.left == null && root.right == null){
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;

        // 如果左节点和右节点的值等于根节点的值则我们需要继续往下寻找
        if (left == root.val){
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val){
            right = findSecondMinimumValue(root.right);
        }

        // 如果都不为-1就取其中的最小值
        if (left != -1 && right != - 1){
            return Math.min(left, right);
        }else if (left != -1){
            return left;
        }else {
            return right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        new FindSecondMinimumValue671().findSecondMinimumValue(root);
    }
}
