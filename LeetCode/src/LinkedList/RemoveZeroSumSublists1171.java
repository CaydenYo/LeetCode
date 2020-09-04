package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/7/27 9:23 下午
 */
public class RemoveZeroSumSublists1171 {
    public ListNode removeZeroSumSublists(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = head;
        while (ptr1.next != null){
            int sum = 0;
            while (ptr2 != null){
                sum += ptr2.val;
                if (sum == 0){
                    break;
                }
                ptr2 = ptr2.next;
            }

            if (sum == 0){
                ptr2 = ptr2.next;
                ptr1.next = ptr2;
            }else {
                ptr1 = ptr1.next;
                ptr2 = ptr1.next;
            }
        }

        return dummy.next;
    }

    public ListNode removeZeroSumSublists1(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        // 若同一和出现多次会覆盖，只记录该sum出现的最后一次节点
        for (ListNode d = dummy;d != null;d = d.next){
            sum += d.val;
            map.put(sum, d);
        }

        // 第二次遍历，若当前节点处sum在下一处出现了则表明两节点之间所有节点和为0，直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy;d != null;d = d.next){
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
