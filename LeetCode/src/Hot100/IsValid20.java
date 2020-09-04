package Hot100;

import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/6/21 9:56 上午
 */
public class IsValid20 {
    public boolean isValid(String s){
        if (s == null || s.equals("")){
            return true;
        }
        Stack<Character> stack =  new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1;i < s.length();i++){
            if (!stack.isEmpty()){
                char tmp = stack.peek();
                if ((tmp == '(' && s.charAt(i) == ')') ||
                        (tmp == '[' && s.charAt(i) == ']') ||
                        (tmp == '{' && s.charAt(i) == '}')){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        new IsValid20().isValid(s);
    }
}
