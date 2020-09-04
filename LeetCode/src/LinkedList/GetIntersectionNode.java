package LinkedList;

public class GetIntersectionNode {
    /**
     * 设两个相交的链表分别为 A-C-D 和 B-C-D
     * 两个指针分别指向A链表和B链表的头
     * 两个指针走完自己的链表后就走另外一个链表，因为每次都走一步
     * 到最后两个指针相遇的时候它们所走过的路程都为 AC+CD+BC
     * 即它们最终会在C点相遇
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA, ptr2 = headB;
        while (ptr1 != ptr2){
            if (ptr1 == null){
                ptr1 = headB;
            }else {
                ptr1 = ptr1.next;
            }
            if (ptr2 == null){
                ptr2 = headA;
            }else {
                ptr2 = ptr2.next;
            }
        }
        return ptr1;
    }
}
