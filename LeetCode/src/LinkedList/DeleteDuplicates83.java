package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/24 5:20 下午
 */
public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == pre.val){
                cur = cur.next;
                pre.next = cur;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head){
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
