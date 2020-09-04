package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/28 9:12 下午
 */
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }
        // 定义一个假节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 初始化pre和end都指向dummy；pre指向待翻转链表的前驱结点，end指向待翻转链表的尾结点
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null){
            // 循环k次找到待翻转链表的结尾，这里需要判断end是否为空
            for (int i = 0;i < k && end != null;i++){
                end = end.next;
            }
            // 如果end == null，即需要翻转的链表节点数小于k，不执行翻转
            if (end == null){
                break;
            }

            // 先记录下end.next，方便后面链接链表
            ListNode next = end.next;
            // 断开链表
            end.next = null;
            // 记录待翻转链表的头结点
            ListNode start = pre.next;
            // 翻转链表
            pre.next = reverse(start);
            //  翻转后头结点变到最后
            start.next = next;
            // 将pre换成下一次要翻转的链表的头结点的上一个节点
            pre = start;
            // 翻转结束，将end置为下一次要翻转的头结点的上一个节点
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        // 单链表为空或者只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }
        // 前一个节点指针
        ListNode preNode = null;
        // 当前节点指针
        ListNode curNode = head;
        // 下一个节点指针
        ListNode nextNode = null;
        while (curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup1(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
