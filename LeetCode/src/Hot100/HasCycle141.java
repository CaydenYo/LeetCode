package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/2 11:57 上午
 */
public class HasCycle141 {
    public boolean hasCycle(ListNode head){
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
