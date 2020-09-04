package WeekendContest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cayden
 * @Date 2020/7/25 10:31 下午
 */
public class RestoreString199 {
    public String restoreString(String s, int[] indices) {
        char[] stringArray = s.toCharArray();
        Map<Integer, Character> hashMap = new HashMap<>();
        for (int i = 0;i < stringArray.length;i++){
            hashMap.put(indices[i], stringArray[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < indices.length;i++){
            sb.append(hashMap.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(new RestoreString199().restoreString(s, indices));
    }
}
