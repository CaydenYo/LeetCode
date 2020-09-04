package Hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cayden
 * @Date 2020/6/22 12:28 上午
 * @Description:
 *      多个链表合为一个链表可以把这个工作分成两两合并的问题
 *      在此基础上可以通过分治的办法降低时间复杂度
 */
public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        // 创建一个小根堆，并定义好排序函数
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : lists){
            if (node != null){
                queue.add(node);
            }
        }

        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null){
                queue.add(cur.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKListsDAQ(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
