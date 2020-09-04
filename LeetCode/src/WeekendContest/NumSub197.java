package WeekendContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/11 10:37 下午
 */
public class NumSub197 {
    public int numSub(String s){
        int len = s.length();
        if (len == 0){
            return 0;
        }
        int count = 0;
        String tmp = "";
        for (int i = 0;i < len;i++){
            if (s.charAt(i) == '1'){
                count += 1;
                for (int j = i + 1;j < len;j++){
                    for (int k = 0;k < j - i + 1;k++){
                        tmp += "1";
                    }
                    if (tmp.equals(s.substring(i, j + 1))){
                        count += 1;
                        tmp = "";
                    }else {
                        break;
                    }
                }
                tmp = "";
            }
        }
        return count;
    }

    /**
     * 统计出每段连续1的个数
     * 对每个数进行等差数列求和
     * 例如1111
     * 如果只有一个1，那么可以移动4次
     * 两个1，移动3次
     * 三个1，移动2次
     * 四个1，移动1次
     * (1 + 4) * 4 / 2 = 10
     * */
    public int numSub1(String s){
        int len = s.length();
        if (len == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '1'){
                int count = 1;
                for (int j = i + 1;j < s.length();j++){
                    if (s.charAt(j) == '1'){
                        count++;
                        i++;
                    }else {
                        break;
                    }
                }
                list.add(count);
            }
        }
        long res = 0;
        for (int i : list){
            res += (1 + i) * i / 2;
        }
        int res1 = (int)(res % (1000000007));
        return res1;
    }

    public int numSub2(String s){
        long count = 0;
        long sum = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '1'){
                count++;
            }else {
                sum += ((1 + count) * count / 2) % 1000000007;
                count = 0;
            }
        }
        sum += ((1 + count) * count / 2) % 1000000007;
        return (int)sum;
    }

    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(new NumSub197().numSub1(s));
    }
}
