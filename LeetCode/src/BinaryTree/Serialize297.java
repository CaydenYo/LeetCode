package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Serialize297 {
    public String serialize(TreeNode root){
        StringBuilder serializeStr = mySerialize(root, new StringBuilder());
        return serializeStr.toString();
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

    public TreeNode deserialize(String data){
        String[] temp = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(temp));
        return myDeserialize(list);
    }

    private TreeNode myDeserialize(List<String> list) {
        TreeNode root;
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }else {
            root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = myDeserialize(list);
            root.right = myDeserialize(list);
        }
        return root;
    }
}
