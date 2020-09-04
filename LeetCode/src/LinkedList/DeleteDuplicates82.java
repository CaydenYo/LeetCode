package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/24 11:54 上午
 */
public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        // 从第二个开始
        ListNode cur = head.next;
        if (cur.val == head.val){
            while (cur != null && cur.val == head.val){
                cur = cur.next;
            }
            head = deleteDuplicates(cur);
        }else {
            head.next = deleteDuplicates(cur);
        }

        return head;
    }


    public ListNode deleteDuplicates1(ListNode head){
        if (head == null){
            return head;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(0);
        // 定义一个尾巴用于尾插法
        ListNode tail = dummy;
        for (ListNode l = head, r = head;l != null;l = r){
            while (r != null && r.val == l.val){
                r = r.next;
            }
            if (l.next == r){
                tail.next = l;
                tail = l;
                tail.next = null;
            }
        }
        return dummy.next;
    }
}
