package Hot100;

/**
 * @Author cayden
 * @Date 2020/7/14 9:25 下午
 */
public class CountSubstring647 {
    /**
     * 最基础的中心扩散法
     * 分子串的长度为奇数和偶数两种情况讨论
     * */
    int count = 0;
    public int countSubstrings(String s){
        for (int i = 0;i < s.length();i++){
            // 奇数
            count(s, i, i);
            // 偶数
            count(s, i, i + 1);
        }
        return count;
    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
    }


    /**
     * 动态规划
     * 字符串s[i...j]是否为回文子串，如果是dp[i][j] = true，否则为false
     * 如果我们目前知道了s[i]和s[j]还有s[i + 1, ... , j - 1]的情况即dp[i + 1][j - 1]的情况
     * 按以下规则计算dp[i][j]:
     * 如果s[i] == s[j]， 那么说明只要dp[i + 1][j - 1]是回文子串，那么dp[i][j]也一定是回文子串
     * 否则dp[i][j]必定不是回文子串
     * 有一种特殊情况就是如果i和j相邻并且s[i] == s[j]，那么dp[i][j] = true，这需要单独拿出来计算
     * */
    public int countSubstrings1(String s){
        int len = s.length();
        if (len == 0){
            return 0;
        }
        // 最少也等于字符串的元素个数
        int num = len;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0;i < len;i++){
            dp[i][i] = true;
        }
        for (int i = len - 1;i >= 0;i--){
            for (int j = i + 1;j < len;j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i == 1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j]){
                    num++;
                }
            }
        }
        return num;
    }
}
