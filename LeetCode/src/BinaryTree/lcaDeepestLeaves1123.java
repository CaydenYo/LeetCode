package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/12 10:04 下午
 */
public class lcaDeepestLeaves1123 {
    Map<TreeNode, Integer> depth_map = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root){
        if (root == null){
            return null;
        }
        int leftD = depth_map.containsKey(root.left) ? depth_map.get(root.left) : getDepth(root.left);
        int rightD = depth_map.containsKey(root.right) ? depth_map.get(root.right) : getDepth(root.right);

        depth_map.put(root.left, leftD);
        depth_map.put(root.right, rightD);

        if (leftD == rightD){
            return root;
        }else if (leftD > rightD){
            return lcaDeepestLeaves(root.left);
        }else {
            return lcaDeepestLeaves(root.right);
        }

    }

    private int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }


    /**
     * 因为需要得知左右子树的深度才可以做判断，因此采取后序遍历
     * 如果左右子树的深度一致，那么root是其中一个候选的公共根，
     * 将它子树的深度与目前最深深度作比较，
     * 如果比最深深度还要深，则更新答案为root
     * 当遍历完整棵树就得出最终答案
     * */
    int maxD = 0;
    TreeNode res;
    public TreeNode lcaDeepestLeaves1(TreeNode root){
        if (root == null){
            return null;
        }
        postorder(root, 0);
        return res;
    }

    private int postorder(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int left = postorder(root.left, depth + 1);
        int right = postorder(root.right, depth + 1);

        if (left == right){
            if (left >= maxD){
                res = root;
                maxD = left;
            }
        }

        return Math.max(left, right);
    }
}
