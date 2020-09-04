package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/13 2:27 下午
 */
public class BTreeGameWinningMove1145 {
    /**
     * 玩家1选了第一个节点后，将树分为了三个部分(可能为空)
     * 第一部分：该节点的左子树
     * 第二部分：该节点的右子树
     * 第三部分：全部节点 - 第一部分 - 第二部分 - 该节点
     * 只要全部节点数的一半 < 以上三个部分中的最大值，玩家而就可以获胜
     * */
    int left = 0;
    int right = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x){
        getNum(root, x);
        return n / 2 < Math.max(Math.max(left, right), n - (left + right) - 1);
    }

    private int getNum(TreeNode node, int x){
        if (node == null){
            return 0;
        }
        int l = getNum(node.left, x);
        int r = getNum(node.right, x);
        if (node.val == x){
            left = l;
            right = r;
        }
        return l + r + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;

        new BTreeGameWinningMove1145().btreeGameWinningMove(root, 5, 2);
    }
}
