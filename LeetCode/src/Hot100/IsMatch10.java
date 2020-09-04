package Hot100;

public class IsMatch10 {
    /**
     * 如果模式串中有星号，它会出现在第二个位置，即pattern[1]（前面符合要求的子串已经在递归过程中被删除）
     * 这种情况下，我们可以直接忽略模式串中的这一部分，或者删除匹配串的第一个字符，
     * 前提是它能够匹配模式串当前位置字符，即pattern[0]
     * 如果两种操作中能有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配
     * */
    public boolean isMatch1(String s, String p){
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            // 如果发现有字符和'*'结合
            // 那我们就匹配该字符0次，跳过该字符和'*'
            // 或者当pattern[0]和text[0]已经匹配后，移动text
            return (isMatch1(s, p.substring(2)) || (first_match && isMatch1(s.substring(1), p)));
        }else {
            // 如果不符合上面的条件，则一一对应进行移动
            return first_match && isMatch1(s.substring(1), p.substring(1));
        }
    }

    /**
     * 自顶向下的办法就是在上面的基础上加一个备忘录memo
     * */
    enum Result{
        TRUE, FALSE
    }

    Result[][] memo;
    public boolean isMatch2(String text, String pattern){
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    private boolean dp(int i, int j, String text, String pattern){
        if (memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        }else {
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) ||
                                                            pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*'){
                ans = (dp(i, j + 2, text, pattern) || (first_match && dp(i + 1, j, text, pattern)));
            }else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans? Result.TRUE : Result.FALSE;
        return ans;
    }

    // 自底向上
    public boolean isMatch3(String text, String pattern){
        // 用于保存中间结果
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // 将右下角置位true
        // 从后往前匹配
        dp[text.length()][pattern.length()] = true;

        // i 从越界开始补齐了最后一列
        // 由于dp的右下角已经赋值
        // 所以不用重复判断所以j从length - 1开始
        for (int i = text.length();i >= 0;i--){
            for (int j = pattern.length() - 1;j >= 0;j--){
                // 判断字符是否相等
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) ||
                                                                pattern.charAt(j) == '.'));
                // 涉及到了*号匹配
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*'){
                    // 状态转换方程
                    // 若后一个字符为*那么就设计到了*号匹配
                    // 规律就是看看跳过两个是否匹配（0次匹配）
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                }else {
                    // 不涉及*号匹配
                    // 就看之前的字符是否匹配以及当前字符是否匹配即可
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }

        // dp[0][0]就代表着之后的全部匹配完成看看是否全部匹配
        return dp[0][0];
    }

    public boolean isMatch4(String text, String pattern){
        if (text == null || pattern == null){
            return false;
        }
        int m = text.length(), n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[i][j]代表text的前i个是否能被pattern的前j个匹配

        dp[0][0] = true;
        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
        for (int j = 2;j <= n; j+= 2) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1;i <= m;i++){
            for (int j = 1;j <= n;j++){
                char tc = text.charAt(i - 1);
                char pc = pattern.charAt(j - 1);
                if (tc == pc || pc == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (pc == '*'){
                    if (dp[i][j - 2]){
                        dp[i][j] = true;
                    }else if (tc == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.'){
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
