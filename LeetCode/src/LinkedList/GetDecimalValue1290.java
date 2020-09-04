package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/28 2:33 下午
 */
public class GetDecimalValue1290 {
    int pow = 0;
    int res = 0;
    public int getDecimalValue(ListNode head){
        if (head.next == null){
            return head.val * (int)(Math.pow(2, pow++));
        }
        res = getDecimalValue(head.next) + head.val * (int)(Math.pow(2, pow++));
        return res;
    }

    // 因为+号优先级高于位操作，所以要加括号
    public int getDecimalValue1(ListNode head){
        int res = 0;
        while (head != null){
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }

  public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        new GetDecimalValue1290().getDecimalValue(head);
    }
}
