package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/13 10:11 下午
 */
public class GetAllElements1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        return merge(list1, list2);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2){
        int len1 = l1.size();
        int len2 = l2.size();

        int p1 = 0;
        int p2 = 0;

        List<Integer> res = new ArrayList<>();
        while (p1 < len1 && p2 < len2){
            if (l1.get(p1) < l2.get(p2)){
                res.add(l1.get(p1++));
            }else {
                res.add(l2.get(p2++));
            }
        }

        while (p1 < len1){
            res.add(l1.get(p1++));
        }
        while (p2 < len2){
            res.add(l2.get(p2++));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(2);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;

        new GetAllElements1305().getAllElements(root, null);
    }
}
