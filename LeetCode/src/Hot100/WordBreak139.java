package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cayden
 * @Date 2020/7/2 10:44 上午
 */
public class WordBreak139 {
    HashSet<String> set;
    HashMap<String, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict){
        set = new HashSet<>(wordDict);
        return dfs(s);
    }

    private boolean dfs(String s){
        if (cache.containsKey(s)){
            return cache.get(s);
        }
        if (s.length() == 0){
            return true;
        }
        for (int end = 1;end <= s.length();end++){
            String cur = s.substring(0, end);
            if(set.contains(cur)){
                if (dfs(s.substring(end))){
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }

    /**
     * 定义dp[i]表示字符串s前i个字符组成的字符串s[0..i - 1]是否能被空格拆成若干个字典中出现的单词。
     * 从前往后计算考虑转移方程，每次转移的时候我们需要枚举包含位置i - 1的最后一个单词
     * 看它是否出现在字典中以及除去这部分的字符串是否合法即可
     * 公式化地说，我们需要枚举s[0..i - 1]中的分割点j，
     * 看s[0..j - 1]组成的字符串s1和s[j..i - 1]组成的字符串s2是否都合法，如果两个字符串合法，s1 + s2也合法
     * 所以dp[i] = dp[j] && check(s[j, i - 1])
     * */
    public boolean wordBreak1(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1;i <= s.length();i++){
            for (int j = 0;j < i;j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
