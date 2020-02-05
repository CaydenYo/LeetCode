package DFS;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    private List<Integer> values = new ArrayList<>();

    /**
     * 快慢指针加递归模拟中序遍历
     * */
    private ListNode findMiddleElement(ListNode head){
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // 当快指针到达list尾部时，慢指针刚好到中间元素
        while (fastPtr != null && fastPtr.next != null){
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        // prevPtr的作用是断开链表
        if (prevPtr != null){
            prevPtr.next = null;
        }
        return slowPtr;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode mid = findMiddleElement(head);
        // mid元素就是BST的根
        TreeNode node = new TreeNode(mid.val);
        // 这种情况list里只有一个元素
        if (head == mid){
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    /**
     * 将单链表转成ArrayList后模拟中序遍历
     * */

    private void mapListToValues(ListNode head){
        while (head != null){
            this.values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertListToBST(int low, int high){
        if (low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));
        // 只有一个元素的情况
        if (low == high){
            return node;
        }
        node.left = convertListToBST(low, mid - 1);
        node.right = convertListToBST(mid + 1, high);

        return node;
    }
}
