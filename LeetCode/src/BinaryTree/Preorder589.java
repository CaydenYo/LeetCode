package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/7 4:14 下午
 */
public class Preorder589 {
    public List<Integer> preorder(Node1 root){
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(Node1 root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        for (Node1 node : root.children){
            preorderTraversal(node, res);
        }
    }
}
