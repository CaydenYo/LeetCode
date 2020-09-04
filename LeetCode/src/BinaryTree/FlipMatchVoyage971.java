package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/10 5:24 下午
 */
public class FlipMatchVoyage971 {
    /**
     * 先声明全局变量res和index
     * 要充分利用先序遍历的根-左-右的特性
     * 如先序遍历数组中的第i个数是根，那么第i + 1个数一定是根的左子树的根节点(无法定位右子树的根节点在voyage的位置)
     * 因此在深度遍历的时候首先判断根节点是否和voyage中第index的值一样
     * 如果不一样直接返回false
     * 如果一样，那么比较左子树的根节点是否与voyage中第index + 1的值一样
     * 如果不一样就交换两个子节点(即先对右节点进行先序遍历)
     * 如果一样就按照正常的顺序进行先序遍历
     * */
    List<Integer> res = new ArrayList<>();
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage){
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    private boolean dfs(TreeNode node, int[] v){
        if (node == null){
            return true;
        }
        if (node.val != v[i]){
            return false;
        }
        i += 1;
        if (node.left != null && node.left.val != v[i]){
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
        }
        return dfs(node.left, v) && dfs(node.right, v);
    }
}
