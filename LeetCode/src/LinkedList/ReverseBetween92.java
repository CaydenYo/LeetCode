package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/24 6:25 下午
 */
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n){
        if (head == null || head.next == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        for (int i = 1;i < m;i++){
            start = start.next;
        }
        ListNode new_tail = start.next;
        ListNode end = head;
        for (int i = 1;i < n;i++){
            end = end.next;
        }
        ListNode tail = end.next;
        end.next = null;

        start.next = reverse(new_tail);
        new_tail.next = tail;

        return dummy.next;
    }

    private ListNode reverse(ListNode new_tail) {
        ListNode pre = new_tail;
        ListNode next = null;
        while (pre != null){
            ListNode tmp = pre.next;
            pre.next = next;
            next = pre;
            pre = tmp;
        }
        return next;
    }


    ListNode reverseBetween1(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween1(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }



    private ListNode reverse1(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
