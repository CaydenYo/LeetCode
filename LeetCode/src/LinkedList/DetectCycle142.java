package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle142 {
    // hash table
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if (visited.contains(node)){
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * 1. 快指针1次走2步，慢指针1次走1步。所以快指针总是走了慢指针两倍的路。
     * 2. 回顾一下阶段1的过程，设头节点到入环点的路途为 n, 那么慢指针走了入环路途的一半（n/2）时，快指针就到达入环点了(走完n了)。
     * 3. 慢指针再继续走完剩下的一般入环路途（剩下的n/2），到达入环点时，快指针已经在环内又走了一个 n 那么远的路了。
     * 4. 为了方便理解，这里先讨论环很大，大于n的情况（其他情况后文补充）。此时，慢指针正处于入环点，快指针距离入环点的距离为n。环内路，可以用此时快指针的位置分割为两段，前面的 n 部分，和后面的 b 部分。
     * 5. 此时开始继续快慢指针跑圈，因为已经在环内了，他们其实就是在一条nbnbnbnbnbnbnb（无尽nb路）上跑步。
     * 6. 慢指针从入环处开始跑b步，距离入环处就剩下了n。此时，快指针则是从距离入环处n步远的位置开始跑了2b步，距离入环处也是剩下了n。他们相遇了，并且距离入环处的距离就是n，n就是头节点到入环点的距离
     * */

    private ListNode getIntersect(ListNode head){
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare){
                return tortoise;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head){
        if (head == null){
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null){
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }


    public ListNode detectCycle3(ListNode head){
        if (head == null){
            return null;
        }
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
                return fast;
            }
        }
        return null;
    }
}
