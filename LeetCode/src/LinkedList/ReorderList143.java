package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/25 1:55 下午
 */
public class ReorderList143 {
    public void reorderList(ListNode head){
        reorder(head);
    }

    public ListNode reorder(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode fast = head.next;
        while (fast.next != null){
            pre = pre.next;
            fast = fast.next;
        }
        if (head.next == fast){
            return head;
        }
        ListNode next = head.next;
        head.next = fast;
        pre.next = null;
        fast.next = reorder(next);

        return head;
    }

    public void reorderList1(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null;
        // 前半部分的元素 >= 后半部分元素
        // 所以要以后半部分元素是否为空作为循环结束条件
        while (second != null){
            ListNode tmp = second.next;
            second.next = head.next;
            head.next = second;
            head = second.next;
            second = tmp;
        }
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new ReorderList143().reorderList(head);
    }
}
