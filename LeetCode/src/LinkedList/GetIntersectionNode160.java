package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/25 9:44 下午
 */
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
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
