package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/27 5:31 下午
 */
public class NumComponents817 {
    /**
     * 对链表进行一次扫描，一个组件在链表中对应一段极长的连续节点，
     * 如果当前的节点在列表G中，并且下一个节点不在列表G中，
     * 我们就找到了一个组件的尾节点，将答案加1
     * */
    public int numComponents(ListNode head, int[] G){
        Set<Integer> set = new HashSet<>();
        for (int num : G){
            set.add(num);
        }
        int ans = 0;
        while (head != null){
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))){
                ans++;
            }
            head = head.next;
        }

        return ans;
    }


    public int numComponents1(ListNode head, int[] G){
        Set<Integer> set = new HashSet<>();
        for (int num : G){
            set.add(num);
        }

        int num = 0;
        while (head != null){
            if (set.contains(head.val)){
                num++;
                set.remove(head.val);
                while (head.next != null){
                    head = head.next;
                    if (set.contains(head.val)){
                        set.remove(head.val);
                    }else {
                        break;
                    }
                }
            }else {
                head = head.next;
            }
        }
        return num;
    }
}
