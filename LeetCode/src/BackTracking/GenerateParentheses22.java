package BackTracking;

import java.util.*;

public class GenerateParentheses22 {
    List<String> res = new ArrayList<>();
    char[] parenthes = {'(',')'};
    private int n;

    public List<String> generateParenthesis(int n) {
        if (n <= 0){
            return res;
        }
        this.n = n;
        StringBuilder sb = new StringBuilder("");
        backtrack(sb);
        return res;
    }

    private void backtrack(StringBuilder str){
        if (str.length() == 2 * n){
            if (check(str)){
                String string = str.toString();
                res.add(string);
            }
        }
        if (str.length() < 2 * n){
            backtrack(str.append(parenthes[0]));
            str.deleteCharAt(str.length() - 1);
        }
        if (str.length() < 2 * n){
            backtrack(str.append(parenthes[1]));
            str.deleteCharAt(str.length() - 1);
        }
    }

    private boolean check(StringBuilder str){
        int pairs = 0;
        String string = str.toString();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < string.length();i++){
            char c = string.charAt(i);
            if (stack.size() == 0){
                stack.push(c);
            }else if (stack.peek() == '(' && c == ')'){
                stack.pop();
                pairs++;
            }else {
                stack.push(c);
            }
        }
        return pairs == n;
    }


    private void dfs(String curStr, int left, int right, List<String> res){
        if (left == 0 && right == 0){
            res.add(curStr);
            return;
        }

        if (left > right){
            return;
        }

        if (left > 0){
            dfs(curStr + "（", left - 1, right, res);
        }
        if (right > 0){
            dfs(curStr + ")", left, right - 1, res);
        }
    }
//    public static void main(String[] args){
//        for (String str: new GenerateParentheses22().generateParenthesis(3)){
//            System.out.println(str);
//        }
//    }

    class Node{
        private String res;
        private int left;
        private int right;

        public Node(String str, int left, int right){
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    // bfs
    public List<String> generateParenthesis1(int n){
        List<String> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0){
                res.add(curNode.res);
            }
            if (curNode.left > 0){
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right){
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }
}
