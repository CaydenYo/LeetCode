package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/21 3:49 下午
 */
public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null){
            if (l1 == null && l2 != null){
                cur.next = l2;
                break;
            }else if (l2 == null && l1 != null){
                cur.next = l1;
                break;
            }else {
                if (l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }else {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
        }

        return dummy.next;
    }

    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }
}
