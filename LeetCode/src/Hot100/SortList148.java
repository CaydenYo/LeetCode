package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/2 8:23 下午
 */
public class SortList148 {
    /**
     * 因为要达到O(nlogn)，明显要用到二分法
     * 这里用快慢指针将链表一分为二，同时用一个pre指针记录慢指针的前一个元素，即第一段链表的最后一个元素
     * 将pre.next赋值为null，这样就正式将链表分成两段
     * 然后就是合并两个链表的递归
     * 可直接参考leetcode 21题的代码
     * */
    public ListNode sortList(ListNode head){
        return head == null ? head : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if (head.next == null){
            return head;
        }

        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        if (left.val < right.val){
            left.next = merge(left.next, right);
            return left;
        }else {
            right.next = merge(left, right.next);
            return right;
        }
    }

}
