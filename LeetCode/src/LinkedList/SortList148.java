package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/25 9:22 下午
 */
public class SortList148 {
    public ListNode sortList(ListNode head){
        return binarySort(head);
    }

    private ListNode binarySort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode right = binarySort(slow);
        ListNode left = binarySort(head);

        return mergeSort(left, right);
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        if (left.val < right.val){
            left.next = mergeSort(left.next, right);
            return left;
        }else {
            right.next = mergeSort(left, right.next);
            return right;
        }
    }
}
