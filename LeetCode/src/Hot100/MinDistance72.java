package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/28 1:30 下午
 */
public class MinDistance72 {
    // 这里的下标 i 不包括 word[i]，同理下标 j 不包括 word[j]
    public int minDistance(String word1, String word2){
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        int len1 = word1Array.length;
        int len2 = word2Array.length;

        // 考虑到空字符，多开一行一列
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 当word2长度为0时，就将word1全部删除
        for (int i = 0;i <= len1;i++){
            dp[i][0] = i;
        }
        // 当word1长度为0时，就插入所有word2字符
        for (int j = 0;j <= len2;j++){
            dp[0][j] = j;
        }
        // 由于多设置了一行一列，所以横纵坐标各有一个偏移
        for (int i = 0;i < len1;i++){
            for (int j = 0;j < len2;j++){
                if (word1Array[i] == word2Array[j]){
                    dp[i + 1][j + 1] = dp[i][j];
                }else {
                    // 在下标i处插入一个字符
                    int insert = dp[i + 1][j] + 1;
                    // 替换一个字符
                    int replace = dp[i][j] + 1;
                    // 删除一个字符
                    int delete = dp[i][j + 1] + 1;

                    dp[i + 1][j + 1] = Math.min(Math.min(insert, replace), delete);
                }
            }
        }
        return dp[len1][len2];
    }
}
