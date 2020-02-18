package DynamicProgramming;

public class LongestPalindrome5DoubleArray {
    public String longestPalindrome(String s) {
        if (s.equals("")){
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];

        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0;i < length;i++){
            for (int j = 0;j < length;j++){
                if (origin.charAt(i) == reverse.charAt(j)){
                    if (i == 0 || j == 0){
                        arr[i][j] = 1;
                    }else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen){
                    int beforeReverse = length - 1 - j;
                    if (beforeReverse + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
