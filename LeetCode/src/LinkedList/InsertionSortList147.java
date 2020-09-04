package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/25 6:13 下午
 */
public class InsertionSortList147 {
    /**
     * 想要排序快，就要尽可能少的做比较
     * 需要一个指针指向当前已排序的最后一个位置，即head
     * 需要另外一个指针pre，每次从表头循环，这里的表头是dummy
     * 每次拿出未排序的节点，首先和最大的比较即head，如果大于前驱就不用排序，head后移，进入下一轮循环
     * 如果比前驱小，则进入内层循环，一次和pre指针比较，插入对应位置即可
     * */
    public ListNode insertionSortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre;
        while (head != null && head.next != null){
            if (head.val <= head.next.val){
                head = head.next;
                continue;
            }
            pre = dummy;
            // 因为引入了一个dummy节点所以可以用pre.next去和元素比较
            // 同时还不丢失pre节点
            while (pre.next.val <= head.next.val){
                pre = pre.next;
            }
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }

        return dummy.next;
    }
}
