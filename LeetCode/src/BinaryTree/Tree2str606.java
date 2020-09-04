package BinaryTree;

/**
 * @Author cayden
 * @Date 2020/8/4 9:56 下午
 */
public class Tree2str606 {
    public String tree2str(TreeNode t){
        if (t == null){
            return "";
        }
        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.equals("") && right.equals("")){
            return result;
        }
        if (left.equals("")){
            return result + "()" + "(" + right + ")";
        }
        if (right.equals("")){
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
