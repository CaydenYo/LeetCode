package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/6/26 4:18 下午
 */
public class GroupAnagrams49 {
    /**
     * 不管三七二十一，先把字符串拆成字符数组，然后对数组进行排序
     * 这样拥有相同字符但是顺序不同的字符串经过操作之后都变成一样的了
     * 将新的字符数组变成字符串当成键传入map中
     * 只要字符串拥有相同的key就将此字符串加入到ans对应的value中
     * 妙
     * */
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }

    /**
     * 我们可以将每个字符串 s 转换为字符数 count，由26个非负整数组成，
     * 表示 a，b，c 的数量等。我们使用这些计数作为哈希映射的基础。
     *
     * 在 Java 中，我们的字符数 count 的散列化表示将是一个用 **＃** 字符分隔的字符串。
     * 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目。
     * */
    public List<List<String>> groupAnagrams1(String[] strs){
        if (strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs){
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < 26;i++){
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }
}
