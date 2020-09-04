package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/8 1:07 下午
 */
public class SubTreeWithAllDeepest865 {
    /**
     * 对每个节点分别求左右子树的高度
     * 如果左子树高度等于右子树高度，则表明这个点就是答案
     * 如果左子树高度小于右子树高度证明答案在右子树
     * 反之，答案在左子树
     * */
    public TreeNode subtreeWithAllDeepest(TreeNode root){
        if (root == null){
            return null;
        }else {
            int ldep = maxDepth(root.left), rdep = maxDepth(root.right);
            if (ldep == rdep){
                return root;
            }else if (ldep > rdep){
                return subtreeWithAllDeepest(root.left);
            }else {
                return subtreeWithAllDeepest(root.right);
            }
        }
    }

    int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 先做一次DFS找到最深节点的深度
     * 然后再做一次深度遍历寻找目标节点
     * 有以下四种情况：
     * 1. 如果node没有左右子树，返回node
     * 2. 如果node左右子树的后代中都有最深节点，返回node
     * 3. 如果只有左子树或者右子树有最深节点，那么返回这棵子树的根节点(即node的左右子树)
     * 4. 当前子树不存在答案，返回null
     * */
    Map<TreeNode, Integer> depth;
    int max_depth;
    public TreeNode subtreeWithAllDeepest1(TreeNode root){
        depth = new HashMap<>();
        depth.put(root, null);
        dfs(root, null);
        max_depth = -1;
        for (Integer d : depth.values()){
            max_depth = Math.max(max_depth, d);
        }

        return answer(root);
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null){
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    private TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth){
            return node;
        }
        TreeNode L = answer(node.left), R = answer(node.right);
        if (L != null && R != null){
            return node;
        }
        if (L != null){
            return L;
        }
        if (R != null){
            return R;
        }
        return null;
    }
}
