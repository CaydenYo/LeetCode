package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/9 6:19 下午
 */
public class Serialize297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = mySerialize(root, new StringBuilder());
        return sb.toString();
    }

    private StringBuilder mySerialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null,");
            return sb;
        }else {
            sb.append(root.val);
            sb.append(",");

            mySerialize(root.left, sb);
            mySerialize(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(dataArray));
        return myDeserialize(list);
    }

    private TreeNode myDeserialize(List<String> serializeList){
        TreeNode root;
        if (serializeList.get(0).equals("null")){
            serializeList.remove(0);
            return null;
        }

        root = new TreeNode(Integer.valueOf(serializeList.get(0)));
        serializeList.remove(0);
        root.left = myDeserialize(serializeList);
        root.right = myDeserialize(serializeList);

        return root;
    }
}
