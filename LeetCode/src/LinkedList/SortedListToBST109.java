package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/25 1:11 上午
 */
public class SortedListToBST109 {
    private List<Integer> values = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head){
        if (head == null){
            return null;
        }
        while (head != null){
            values.add(head.val);
            head = head.next;
        }
        return convertToBST(0, values.size() - 1);
    }

    private TreeNode convertToBST(int low, int high){
        if (low == high){
            return new TreeNode(values.get(low));
        }
        if (low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = convertToBST(low, mid - 1);
        root.right = convertToBST(mid + 1, high);

        return root;
    }


    public TreeNode sortedListToBST1(ListNode head){
        if (head == null){
            return null;
        }else if (head.next == null){
            return new TreeNode(head.val);
        }

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null){
            pre.next = null;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST1(head);
        root.right = sortedListToBST1(slow.next);

        return root;
    }
}
