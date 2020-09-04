package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/15 10:35 上午
 */
public class RemoveInvalidParentheses301 {
    int maxLen = Integer.MIN_VALUE;
    public List<String> removeInvalidParentheses(String s){
        Set<String> all = new HashSet<>();
        List<String> res = new ArrayList<>();
        dfs(s, 0, "", all);
        for (String str : all){
            if (str.length() == maxLen){
                res.add(str);
            }
        }
        return res;
    }

    private void dfs(String s, int index, String curr, Set<String> all){
        if (index == s.length()){
            if (!all.contains(curr) && isValid(curr)){
                maxLen = Math.max(maxLen, curr.length());
                all.add(curr);
            }
            return;
        }
        if (s.charAt(index) != '(' && s.charAt(index) != ')'){
            dfs(s, index + 1, curr + s.charAt(index), all);
        }else {
            dfs(s, index + 1, curr + s.charAt(index), all);
            dfs(s, index + 1, curr, all);
        }
    }

    private boolean isValid(String s){
        if (s.length() < maxLen){
            return false;
        }
        char[] array = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0;i < s.length();i++){
            char c = array[i];
            if (c == '(' || c == ')'){
                if (!stack.isEmpty() && c == ')' && stack.peekLast() == '('){
                    stack.pollLast();
                }else {
                    stack.addLast(c);
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * 优化DFS：
     * 我们需要先找出不合法的左括号个数和右括号个数
     * 利用dfs不断删除'('或者')'，直到不合法个数为0
     * 检验删除后的括号串是否合法
     * */
    List<String> ans;
    public List<String> removeInvalidParentheses1(String s){
        int leftDelete = 0;
        int rightDelete = 0;
        ans = new ArrayList<>();
        // 因为一个合法的括号子串，在')'的左边一定有'('，所以我们先计算'('的个数
        for (char c : s.toCharArray()){
            if (c == '('){
                leftDelete++;
            }else if (c == ')'){
                if (leftDelete > 0){
                    leftDelete--;
                }else {
                    rightDelete++;
                }
            }
        }
        dfs(s, 0, leftDelete, rightDelete);
        return ans;
    }

    private void dfs(String s, int idx, int leftDelete, int rightDelete){
        if (leftDelete == 0 && rightDelete == 0){
            if (check(s)){
                ans.add(s);
            }
            return;
        }
        for(int i = idx;i < s.length();i++){
            // 去重
            if(i-1 >= idx && s.charAt(i) == s.charAt(i - 1))continue;
            String s2 = s.substring(0, i) + s.substring(i + 1, s.length());
            if(leftDelete > 0 && s.charAt(i) == '('){
                dfs(s2, i, leftDelete - 1, rightDelete);
            }
            if(rightDelete > 0 && s.charAt(i) == ')'){
                dfs(s2, i, leftDelete, rightDelete-1);
            }
        }
    }

    private boolean check(String s){
        int cnt = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                cnt++;
            }else if (c == ')'){
                cnt--;
                if (cnt < 0){
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    /**
     * 本题说的是删除最少的括号
     * 如果我们每次只删除一个括号，然后观察被删除一个括号后是否合法
     * 如果合法就不需要继续删除，因此不需要将遍历进行到底，而是层层深入
     * 一旦达到需求就不再深入
     *
     * 上一层和下一层之间的关系为：
     * 把上一层中的每个元素都拿出来
     * 针对每个元素列举删除一个括号后的所有情况，添加到下一层中
     * */
    public List<String> removeInvalidParentheses2(String s){
        List<String> res = new ArrayList<>();
        if (s == null || s.equals("")){
            res.add("");
            return res;
        }
        Deque<String> queue = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        queue.addLast(s);
        boolean flag = false;
        while (!queue.isEmpty()){
            if (flag){
                return res;
            }
            int size = queue.size();
            for (int i = size;i > 0;i--){
                String curr = queue.pollFirst();
                if (check(curr)){
                    res.add(curr);
                    flag = true;
                }
                if (flag){
                    continue;
                }
                for (int j = 0;j < curr.length();j++){
                    if (curr.charAt(j) == '(' || curr.charAt(j) == ')'){
                        String str = "";
                        str = curr.substring(0, j) + curr.substring(j + 1);
                        if (hashSet.add(str)){
                            queue.addLast(str);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()){
            res.add("");
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "()())()";
        List<String> res = new RemoveInvalidParentheses301().removeInvalidParentheses2(s);
        for (String str : res){
            System.out.println(str);
        }
    }
}
