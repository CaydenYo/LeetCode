package BinarySearchTree;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null){
            insertHelper(root, val);
        }else {
            root = new TreeNode(val);
        }
        return root;
    }

    private void insertHelper(TreeNode root, int val){
        if (root.val > val){
            if (root.left == null){
                root.left = new TreeNode(val);
            }else {
                insertHelper(root.left, val);
            }
        }else {
            if (root.right == null){
                root.right = new TreeNode(val);
            }else {
                insertHelper(root.right,val);
            }
        }
    }

    // more succinct
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // insert into the right subtree
        if (val > root.val){
            root.right = insertIntoBST(root.right, val);
        }else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
