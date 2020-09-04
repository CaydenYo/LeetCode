package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/13 8:55 下午
 */
public class ConvertBST538 {
    // 记录到目前为止比此节点大的值的累加值
    int num = 0;
    /**
     * 因为是二叉搜索树，
     * 所以它的中序遍历（左中右）得出来的结果是从小到大
     * 如果把左右调换那就是从大到小
     * 在遍历的过程中记录累加值
     * 此累加值就是遍历到某个节点时，比这个节点的值都要大的节点的累计值
     * */
    public TreeNode convertBST(TreeNode root){
        if (root == null){
            return null;
        }
        convertBST(root.right);
        root.val = root.val + num;
        num = root.val;
        convertBST(root.left);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left = new TreeNode(2);

        new ConvertBST538().convertBST(root);
    }
}
