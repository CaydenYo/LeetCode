package Hot100;

public class LongestPalindrome5 {
    public String longestPalindrome(String s){
        if (s == null || s.length() < 1){
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0;i < s.length();i++){
            int len1 = extendAroundCenter(s, i, i);
            int len2 = extendAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start + 1){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int extendAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * 状态：dp[i][j]表示子串s[i..j]是否为回文子串
     * 得到状态转移方程：dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     * 由于是下标访问，所以要考虑边界问题
     * 边界条件：j - 1 - (i + 1) + 1 < 2，整理得 j - i < 3，即s[i..j]长度为2或者3 时不用检查子串是否回文
     * 初始化：dp[i][i] = true
     * 输出：在得到一个状态的值为true的时候，记录起始位置和长度，填表完成后再截取
     * */

    public String longestPalindrome1(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] represents if s[i..j] is palindrome
        boolean[][] dp = new boolean[len][len];

        for (int i = 0;i < len;i++){
            dp[i][i] = true;
        }

        for (int j = 1;j < len;j++){
            for (int i = 0;i < len;i++){
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // if dp[i][j] == true, we need to record its length
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
