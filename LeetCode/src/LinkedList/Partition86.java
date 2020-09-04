package LinkedList;

import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/24 5:28 下午
 */
public class Partition86 {
    public ListNode partition(ListNode head, int x){
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode head1 = new ListNode(0);
        ListNode curr1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode curr2 = head2;
        while (curr != null){
            if (curr.val < x){
                curr1.next = new ListNode(curr.val);
                curr1 = curr1.next;
            }else {
                curr2.next = new ListNode(curr.val);
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        curr1.next = head2.next;
        return head1.next;
    }
}
