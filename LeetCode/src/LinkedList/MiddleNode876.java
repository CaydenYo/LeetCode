package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/27 6:28 下午
 */
public class MiddleNode876 {
    public ListNode middleNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
