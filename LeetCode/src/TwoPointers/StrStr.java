package TwoPointers;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        if (needleLen == 0){
            return 0;
        }
        int haystackLen = haystack.length();
        if (haystackLen < needleLen){
            return -1;
        }
        int i = 0, j = 0;
        while (i < haystackLen && j < needleLen){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needleLen){
            return i - needleLen;
        }else {
            return -1;
        }
    }
}
