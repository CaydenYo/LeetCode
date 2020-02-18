package Recursion;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private ListNode swap(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode headNextNext = head.next.next;
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = swap(headNextNext);
        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode ans = new ListNode(0);
        ans.next = new SwapPairs().swapPairs(head);
        while (ans.next != null){
            System.out.println(ans.next.val);
            ans = ans.next;
        }
    }
}
