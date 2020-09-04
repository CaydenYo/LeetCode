package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/27 2:41 下午
 */
public class NumMatchingSubseq792 {
    /**
     * 总共就26个字母，用链表数组为每个字母建立索引表，
     * 顺序存放该字符在S中出现的位置
     * 对于每个单词我们顺序查找单词中字母在S中的位置
     * 如果当前字母的位置小于或者等于上一个字母的位置就直接返回-1
     * */
    List<Integer>[] index = new ArrayList[26];
    public int numMatchingSubseq(String S, String[] words){
        for (int i = 0;i < S.length();i++){
            char ch = S.charAt(i);
            if (index[ch - 'a'] == null){
                index[ch - 'a'] = new ArrayList<>();
            }
            index[ch - 'a'].add(i);
        }
        int res = 0, pre;
        for (String str : words){
            // 初始化pre为-1
            pre = -1;
            for (int i = 0;i < str.length();i++){
                pre = binarySearch(str.charAt(i) - 'a', pre);
                if (pre == -1){
                    break;
                }
            }
            if (pre != -1){
                res++;
            }
        }
        return res;
    }

    private int binarySearch(int i, int pre) {
        if (index[i] == null){
            return -1;
        }
        int l = 0, r = index[i].size() - 1;
        if (pre == -1){
            return index[i].get(0);
        }
        if (index[i].get(r) <= pre) return -1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if (index[i].get(mid) <= pre){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return index[i].get(l);
    }
}
