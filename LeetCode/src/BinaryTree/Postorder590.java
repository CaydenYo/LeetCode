package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/7 4:17 下午
 */
public class Postorder590 {
    public List<Integer> postorder(Node1 root){
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(Node1 root, List<Integer> res) {
        if (root == null){
            return;
        }
        for (Node1 node : root.children){
            postorderTraversal(node, res);
        }
        res.add(root.val);
    }
}
