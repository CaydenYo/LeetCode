package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/8/5 3:20 下午
 */
public class FindDuplicateSubtrees652 {
    /**
     * 本题需要寻找重复的子树，这里重复的子树是指具有相同的结构以及相同的结点值。我们需要进行序列化的操作。
     * 序列化：通过一个编码和解码的方式来得到原数据。对于原数据来说，使用相同序列化后的结果肯定是唯一的
     * 所以，既然要寻找重复子树，那么只需要将所有子树都用相同的方式进行序列化，
     * 如果在这个过程中发现有相同的序列，那么这个肯定是相同的子树
     * */
    List<TreeNode> result = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        if (root == null){
            return result;
        }
        serialize(root);
        return result;
    }

    public String serialize(TreeNode root){
        if (root == null){
            return "null";
        }
        String str = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2){
            result.add(root);
        }
        return str;
    }
}
