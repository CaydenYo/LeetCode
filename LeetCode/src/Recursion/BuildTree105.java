package Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/7/16 3:43 下午
 */
public class BuildTree105 {
    /**
     * 先序遍历的顺序是根节点，左子树，右子树；中序遍历的顺序是左子树，根节点，右子树
     * 所以我们只需要根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置
     * 在中序遍历中的根节点的左边一定是左子树的根节点，而右边是右子树的节点但不一定是根节点
     * 所以就可以递归的生成左子树和右子树
     *
     * 在中序遍历中添加start和end两个指针
     * 如果在中序遍历中找到根节点i
     * 那么左子树的范围为[start, i), 右子树的范围为[i + 1, end)
     * 因为左闭右开，当start == end时意味着此区间不再有元素，递归完成
     * */
    private int[] preorder;
    private int idx = 0;
    Map<Integer, Integer> in_map;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        in_map = new HashMap<>();
        for (int i = 0;i < inorder.length;i++){
            in_map.put(inorder[i], i);
        }
        TreeNode root = helper(0, inorder.length);
        return root;
    }

    public TreeNode helper(int start, int end){
        if (start == end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = helper(start, in_map.get(root.val));
        root.right = helper(in_map.get(root.val) + 1, end);

        return root;
    }
}
