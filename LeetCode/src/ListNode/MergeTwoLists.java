package ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode(0);
        dummy1.next = l1;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = l2;
        ListNode ans = new ListNode(0);
        ListNode newHead = ans;
        while (dummy1.next != null && dummy2.next != null){
            if (dummy1.next.val <= dummy2.next.val){
                ans.next = new ListNode(dummy1.next.val);
                dummy1 = dummy1.next;
            }else {
                ans.next = new ListNode(dummy2.next.val);
                dummy2 = dummy2.next;
            }
            ans = ans.next;
        }

        if (dummy1.next != null){
            ans.next = dummy1.next;
        }
        if (dummy2.next != null){
            ans.next = dummy2.next;
        }

        return newHead.next;
    }

    // recursion version
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode dummy = new MergeTwoLists().mergeTwoLists(l1, l2);
        while (dummy.next != null){
            System.out.println(dummy.next.val);
            dummy = dummy.next;
        }
    }
}
