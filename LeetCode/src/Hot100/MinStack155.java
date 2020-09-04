package Hot100;

import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/7/3 3:49 下午
 */

/**
 * 每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值
 * */
public class MinStack155 {
    Stack<Integer> stack;

    public MinStack155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else {
            int min = Math.min(stack.peek(), x);
            stack.push(x);
            stack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
       return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
