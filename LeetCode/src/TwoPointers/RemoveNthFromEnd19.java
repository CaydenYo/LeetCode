package TwoPointers;

public class RemoveNthFromEnd19 {
    public RemoveNthFromEnd19(ListNode head, int n){
        head = removeNthFromEnd19(head, n);
        System.out.println(head.val);
        while (head.next != null){
            head = head.next;
            System.out.println(head.val);
        }
    }

    /* 两次遍历法
    private ListNode removeNthFromEnd19(ListNode head, int n) {
        // 在链表头添加一个哑点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
     */

    // 一次遍历法，双指针
    private ListNode removeNthFromEnd19(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0;i < n + 1;i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode trueHead = head;
        for (int i = 1;i < arr.length;i++){
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        new RemoveNthFromEnd19(trueHead,2);
    }
}
