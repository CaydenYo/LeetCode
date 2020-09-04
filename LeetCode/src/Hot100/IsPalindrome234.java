package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/6 9:47 下午
 */
public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head){
        if (head == null){
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second part of list
        ListNode pre = null;
        ListNode curr = slow.next;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        ListNode p1 = head;
        while (pre != null){
            if (pre.val != p1.val){
                return false;
            }
            pre = pre.next;
            p1 = p1.next;
        }

        return true;
    }


    /**
     * 另一种方法：使用栈
     * 利用栈先进后出的特点实现从后向前遍历
     * 将所有元素入栈之后，再依次pop()和链表从前往后一一比较
     * */
}
