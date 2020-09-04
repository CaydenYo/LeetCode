package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/3 5:03 下午
 */
public class Serialize449 {
    /**
     * 普通的二叉树需要两种遍历才能固定二叉树
     * 对于BST而言，得到BST的前序遍历后，第一个元素值为根节点
     * 小于根节点元素的为左子树
     * 大于根节点的元素为右子树
     * */
    public String serialize(TreeNode root){
        if (root == null){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        helper(root, stringBuilder);
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private void helper(TreeNode root, StringBuilder sb){
        if (root == null){
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    public TreeNode deserialize(String data){
        if (data == null || data.length() == 0){
            return null;
        }
        String[] arr = data.split(",");
        return builder(arr, 0, arr.length - 1);
    }

    private TreeNode builder(String[] arr, int lo, int hi) {
        if (lo > hi){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
        // 这一步的目的是当找不到比首元素大的元素(即没有右子树)时也能让递归进行下去
        int index = hi + 1;
        // 找到第一个比首元素大的元素
        for (int i = lo + 1;i <= hi;i++){
            if (Integer.valueOf(arr[i]) > root.val){
                index = i;
                break;
            }
        }
        root.left = builder(arr, lo + 1, index - 1);
        root.right = builder(arr, index, hi);
        return root;
    }
}
