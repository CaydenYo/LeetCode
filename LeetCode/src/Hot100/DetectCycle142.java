package Hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/2 12:15 下午
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 假设链表有a + b个节点
     * 其中表头到环入口有a个节点，环有b个节点
     * 设快慢指针分别走了f，s步
     * 其中有f = 2 * s, f = s + nb
     * 可得f = 2nb, s = nb
     * 又知如果让指针从头部开始一直往前走并统计k步
     * 那么所有走到环入口的步数为k = a + nb
     * 已知目前慢指针已经走了nb步，那么再走a步就到达链表入口
     * 此时快指针指向表头和慢指针一起每次只向前走1步
     * 它们走a步后就会在环入口相遇
     * */
    public ListNode detectCycle1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
