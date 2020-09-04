package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/12 3:00 下午
 */
public class PathInZigZagTree1104 {
    /**
     * 如果是一棵普通的满二叉树，对于某个节点而言
     * 它的父节点的label本来应该等于它的编号label除以2
     * 在zigzag型的满二叉树中，某一节点的父子节点是原来父节点的对称节点
     * 求对称节点值的公式如下：
     * 当前层的头节点值 + 当前层的尾节点值 - 原父节点的值
     * 例如在第三层中：4，5，6，7
     * 14本来的父节点是7，在zigzag树中是4
     * 则 4 + 7 - 7 = 4，验证正确
     * */
    List<Integer> res;
    public List<Integer> pathInZigZagTree(int label){
        res = new ArrayList<>();
        int head = 1;
        int row = 1;
        while (head * 2 <= label){
            head *= 2;
            row++;
        }
        fillPath(row, head, label);
        return res;
    }

    private void fillPath(int row, int head, int label){
        if (row == 1){
            res.add(1);
            return;
        }
        // 原父节点的值
        int originalParent = label / 2;
        /**
         * 上一层的原头节点的值是head / 2，尾结点的值是head / 2 - 1
         * 于是在zigzag中的父节点的值就等于头尾相加再减去原父节点的值
         * */
        int currentParent = head / 2 + head - 1 - originalParent;
        fillPath(row - 1, head / 2, currentParent);
        res.add(label);
    }
}
