package LinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/27 6:42 下午
 */
public class NextLargerNodes1019 {
    public int[] nextLargerNodes(ListNode head){
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> nums = new ArrayList<>();
        while (head != null){
            nums.add(head.val);
            head = head.next;
        }
        int[] res = new int[nums.size()];
        for (int i = 0;i < nums.size();i++){
            if (stack.isEmpty()){
                stack.addLast(i);
            }else {
                int val = nums.get(i);
                if (val <= nums.get(stack.peekLast())){
                    stack.addLast(i);
                }else {
                    while (!stack.isEmpty() && val > nums.get(stack.peekLast())){
                        res[stack.pollLast()] = val;
                    }
                    stack.addLast(i);
                }
            }
        }

        while (!stack.isEmpty()){
            res[stack.pollLast()] = 0;
        }

        return res;
    }
}
