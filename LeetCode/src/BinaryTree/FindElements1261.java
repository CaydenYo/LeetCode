package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/13 8:25 下午
 */
public class FindElements1261 {
    TreeNode root;
    public FindElements1261(TreeNode root){
        this.root = root;
    }

    public boolean find(int target){
        return find(root, target);
    }

    private boolean find(TreeNode root, int target){
        if (root == null){
            return false;
        }
        if (root.val == -1){
            root.val = 0;
        }
        if (root.val == target){
            return true;
        }
        if (root.left != null){
            root.left.val = 2 * root.val + 1;
        }
        if (root.right != null){
            root.right.val = 2 * root.val + 2;
        }
        if(find(root.left, target)){
            return true;
        }else if(find(root.right, target)){
            return true;
        }
        return false;
    }
}
