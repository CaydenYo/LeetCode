package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/23 8:51 下午
 */
public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0 || lists == null){
            return null;
        }
        return binaryMerge(lists, 0, lists.length - 1);
    }

    private ListNode binaryMerge(ListNode[] lists, int start, int end) {
        if (start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = binaryMerge(lists, start, mid);
        ListNode l2 = binaryMerge(lists, mid + 1, end);

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
