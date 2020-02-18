package ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode ll1 = l1, ll2 = l2, curr = dummyHead;
        int carry = 0;
        while (ll1 != null || ll2 != null){
            int x = (ll1 != null) ? ll1.val : 0;
            int y = (ll2 != null) ? ll2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (ll1 != null){
                ll1 = ll1.next;
            }
            if (ll2 != null){
                ll2 = ll2.next;
            }
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l3 = l2;
        for (int i = 0;i < 9;i++){
            l3.next = new ListNode(9);
            l3 = l3.next;
        }

        new AddTwoNumbers().addTwoNumbers(l1,l2);
    }
}
