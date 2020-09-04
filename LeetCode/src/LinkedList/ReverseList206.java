package LinkedList;

public class ReverseList206 {
    public ListNode reverseList1(ListNode head){
        return reverse(null, head);
    }

    public ListNode reverse(ListNode next, ListNode prev){
        if (prev != null){
            ListNode tmp = prev.next;
            prev.next = next;
            return reverse(prev, tmp);
        }
        return next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
