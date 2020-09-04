package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/4 4:40 下午
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head){
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null){
            return pre;
        }else {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            return reverse(pre, next);
        }
    }

    public ListNode reverseListIterate(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
