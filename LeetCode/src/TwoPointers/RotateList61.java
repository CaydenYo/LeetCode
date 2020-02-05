package TwoPointers;

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        int n;
        ListNode old_tail = head;
        for (n = 1; old_tail.next != null; n++){
            old_tail = old_tail.next;
        }
        // 将单链表头尾相接形成闭环
        old_tail.next = head;

        // 寻找新尾巴, 新尾巴在头前面一个元素
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++){
            new_tail = new_tail.next;
        }

        head = new_tail.next;
        new_tail.next = null;

        return head;
    }
}
