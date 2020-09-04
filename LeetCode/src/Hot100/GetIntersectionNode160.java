package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/3 4:11 下午
 */
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }

        int len1 = 0;
        ListNode head1 = headA;
        while (head1 != null){
            head1 = head1.next;
            len1++;
        }
        int len2 = 0;
        ListNode head2 = headB;
        while (head2 != null){
            head2 = head2.next;
            len2++;
        }

        if (len1 > len2){
            for (int i = 0;i < len1 - len2;i++){
                headA = headA.next;
            }
        }else if (len1 < len2){
            for (int i = 0;i < len2 - len1;i++){
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
