package LinkedList;

public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null){
            if (fast.val == val){
                fast = fast.next;
                slow.next = fast;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return dummy.next;
    }
}
