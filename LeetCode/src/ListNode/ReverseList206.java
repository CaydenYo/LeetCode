package ListNode;

import java.util.List;
import java.util.Stack;

public class ReverseList206 {
    public ListNode myReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        stack.add(head);
        while (head.next != null){
            head = head.next;
            stack.add(head);
        }

        ListNode newHead = new ListNode(stack.pop().val);
        ListNode temphead = newHead;
        while (!stack.empty()){
            temphead.next = new ListNode(stack.pop().val);
            temphead = temphead.next;
        }
        return newHead;
    }

    // while version
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr.next != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return curr;
    }

    // post recursion version
    public ListNode reverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // pre recursion version
    public ListNode reverseList3(ListNode head){
        return reverseList4(null, head);
    }

    public ListNode reverseList4(ListNode pre, ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverseList4(cur, next);
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5;i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = new ReverseList206().reverseList3(head);

        while(dummy.next != null){
            System.out.println(dummy.next.val);
            dummy = dummy.next;
        }
    }
}
