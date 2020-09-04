package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/28 3:53 下午
 */
public class IsSubPath1367 {
    public boolean isSubPath(ListNode head, TreeNode root){
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root){
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
