package Stack;

import java.util.Stack;

public class IsValidParenthesis20 {
    public boolean isValid(String s) {
        if (s == null || s.equals("")){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (stack.size() == 0){
                stack.push(c);
            }else if (isSym(stack.peek(),c)){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isSym(char c1, char c2){
        return ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'));
    }

    public static void main(String[] args){
        System.out.println(new IsValidParenthesis20().isValid("()"));
    }
}
