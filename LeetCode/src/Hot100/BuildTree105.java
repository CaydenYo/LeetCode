package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/6/30 6:21 下午
 */
public class BuildTree105 {
    /**
     * 先序遍历的顺序是根节点，左子树，右子树；中序遍历的顺序是左子树，根节点，右子树
     * 所以我们只需要根据先序遍历得到根节点，然后再中序遍历中找到根节点的位置，
     * 在中序遍历中的根节点的左边就是(一定)左子树的根节点，而右边是右子树的节点(对于右子树而言，右边这个节点不一定是根节点)
     * 所以我们生成左子树和右子树就可以递归进行
     *
     * 如何控制递归出口：
     * 可以在中序遍历中添加start指针和end指针
     * 如果我们在中序遍历中找到根节点，下标为i
     * 那么左子树的范围为[start, i), 右子树的范围为[i + 1, end)
     * 因为是左闭右开，所以一旦start == end意味着此区间不再有元素，即递归完成
     * */
    private int[] preorder;
    private Map<Integer, Integer> inorder_map = new HashMap<>();
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        for (int i = 0;i < inorder.length;i++){
            inorder_map.put(inorder[i], i);
        }

        return helper(0, inorder.length);
    }

    private TreeNode helper(int start, int end){
        if (start == end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        int newIndex = inorder_map.get(root.val);
        root.left = helper(start, newIndex);
        root.right = helper(newIndex + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        new BuildTree105().buildTree(preorder, inorder);
    }
}
