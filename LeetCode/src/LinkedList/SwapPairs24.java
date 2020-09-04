package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/23 11:08 下午
 */
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head){
        return swap(head);
    }

    private ListNode swap(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        l1.next = swapPairs(l2.next);
        l2.next = l1;
        return l2;
    }
}
