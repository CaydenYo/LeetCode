package Hot100;

import java.util.Stack;

/**
 * @Author cayden
 * @Date 2020/6/22 10:20 下午
 */
public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0;i < s.length();i++){
            for (int j = i + 2;j < s.length();j += 2){
                if (isValid(s.substring(i, j))){
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if (!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 定义一个dp数组，其中第i个元素表示以下标为i的字符结尾的最长有效子字符串的长度
     * 1. 如果s[i] = '）' 且s[i - 1] = '(', 也就是字符串形如"...()", 我们可以推出
     *      dp[i] = dp[i - 2] + 2 (要加上在"()"之前的符合调价你的子字符串长度，所以加上dp[i - 2])
     * 2. 如果s[i] = '）' 且s[i - 1] = ')', 也就是字符串形如"...(())", 我们可以推出
     *      如果在s[i - dp[i - 1] - 1] = '(' 的话，那么
     *      dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
     *      这背后的原因是如果倒数第二个')'是一个有效子字符串的一部分(记为subs)，对于最后一个')',
     *      如果它是一个更长子串的一部分，那么它一定有一个对应的'('的位置在倒数第二个')'所在的有效字符串的前面
     *      也就是subs的前面，即s[i - dp[i - 1] - 1] = '(' ，那么就可以加上dp[i - 1] + 2
     *      除此之外，我们还需要把"(,subs,)"之前的有效子字符串的长度也加上，即dp[i - dp[i - 1] - 2]
     * */
    public int longestValidParenthesesDP(String s){
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1;i < s.length();i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }


    /**
     * 1. 栈底永远保存着当前有效子串的前一个字符的下标，就像个守门员守在那里，所以一开始要将-1放入栈中
     * 2. 遇到左括号就入栈
     * 3. 遇到右括号将栈顶元素出栈。此时有两种情况：
     *  (1) 如果栈顶元素出栈后，栈内剩下的元素不为空，则说明弹出的这个栈顶元素一定是左括号。
     *  (2) 如果栈顶元素出栈后，栈内为空，则说明刚刚弹出的这个栈顶元素就是之前的"有效子串前一位的字符下标"，
     *      守门员都没了，所以此时应该使用当前的右括号的下标入栈，更新这个"有效子串前一位的字符下标"
     * */
    public int longestValidParenthesesStack(String s){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheseTwoTraversal(String s){
        int left = 0;
        int right = 0;
        int maxLength = 0;

        // from left to right
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxLength = Math.max(maxLength, 2 * right);
            }else if (right > left){
                left = 0;
                right = 0;
            }
        }

        left = right = 0;
        // from right to left
        for (int i = s.length() - 1;i >= 0;i--){
            if (s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            }else if (left > right){
                left = right = 0;
            }
        }

        return maxLength;
    }
}
