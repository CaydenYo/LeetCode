package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/11 6:21 下午
 */
public class DecodeString394 {
    /**
     * 1. 如果遇到']'就一直在栈中找到'['并且把它们之间的字符连接起来
     *    然后将'['前面的数字连接起来作为次数，将循环相加后的字符串再次入栈
     * 2. 如果遇到除']'以外的字符就直接入栈
     * 3. 最后因为不会再遇到']'导致没有触发出栈操作，我们需要在遍历完字符串后
     *    将栈内里的元素全部弹出连接成字符串返回
     * */
    public String decodeString(String s){
        if (s == null || s.equals("")){
            return "";
        }
        int len = s.length();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0;i < len;i++){
            char c = s.charAt(i);
            if (c == ']'){
                String str = "";
                while (!stack.peekLast().equals("[")){
                    str = stack.pollLast() + str;
                }
                // pop掉'['
                stack.pollLast();
                // 获得重复次数
                String num = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast().charAt(0))){
                    num = stack.pollLast() + num;
                }
                int count = Integer.parseInt(num);
                String tmp = "";
                for (int j = 0;j < count;j++){
                    tmp += str;
                }
                stack.addLast(tmp);
            }else {
                stack.addLast(c + "");
            }
        }

        String res = "";
        while (!stack.isEmpty()){
            res = stack.pollLast() + res;
        }
        return res;
    }

    /**
     * 构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
     * 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
     * 当 c 为字母时，在 res 尾部添加 c；
     * 当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置0：
     *      记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
     *      记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
     *      进入到新 [ 后，res 和 multi 重新记录。
     * 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
     * last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
     * cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
     * 返回字符串 res。
     * */
    public String decodeString1(String s){
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        Deque<Integer> stack_multi = new ArrayDeque<>();
        Deque<String> stack_res = new ArrayDeque<>();
        for (Character c : s.toCharArray()){
            if (c == '['){
                stack_multi.addLast(multi);
                stack_res.addLast(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            }else if (c == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pollLast();
                for (int i = 0;i < cur_multi;i++){
                    tmp.append(sb);
                }
                sb = new StringBuilder(stack_res.pollLast() + tmp);
            }else if (Character.isDigit(c)){
                multi = multi * 10 + Integer.parseInt(c + "");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new DecodeString394().decodeString("3[a]2[bc]");
    }
}
