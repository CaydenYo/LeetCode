package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        int front = 0;
        int back = list.size() - 1;
        while (front < back){
            if (list.get(front).equals(list.get(back))){
                return false;
            }
            front++;
            back--;
        }

        return true;
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public boolean isPalindrome2(ListNode head){
        if (head == null){
            return true;
        }
        // find split point
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode p1 = head;
        while (prev != null){
            if (prev.val != p1.val){
                return false;
            }
            p1 = p1.next;
            prev = prev.next;
        }

        return true;
    }



    public boolean isPalindrome3(ListNode head){
        if (head == null){
            return true;
        }
        // find split point
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        ListNode curr = slow.next;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        ListNode p1 = head;
        while (pre != null){
            if (p1.val != pre.val){
                return false;
            }
            p1 = p1.next;
            pre = pre.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);

        new IsPalindrome234().isPalindrome(head);
    }
}
