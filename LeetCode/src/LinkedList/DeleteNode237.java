package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/26 2:52 下午
 */
public class DeleteNode237 {
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
