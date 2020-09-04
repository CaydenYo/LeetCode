package LinkedList;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/26 3:19 下午
 */
public class AddTwoNumbers445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null){
            stack1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.addLast(l2.val);
            l2 = l2.next;
        }

        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0;
        int i = stack1.size() < stack2.size() ? stack1.size() : stack2.size();
        for (int j = 0;j < i;j++){
            int sum = carry + stack1.pollLast() + stack2.pollLast();
            carry = sum / 10;
            result.addLast(sum % 10);
        }

        if (stack1.isEmpty()){
            while (!stack2.isEmpty()){
                int sum = stack2.pollLast() + carry;
                carry = sum / 10;
                result.addLast(sum % 10);
            }
        }else {
            while (!stack1.isEmpty()){
                int sum = stack1.pollLast() + carry;
                carry = sum / 10;
                result.addLast(sum % 10);
            }
        }

        if (carry > 0){
            result.addLast(1);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!result.isEmpty()){
            curr.next = new ListNode(result.pollLast());
            curr = curr.next;
        }



        return dummy.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        new AddTwoNumbers445().addTwoNumbers(l1, l2);
    }
}
