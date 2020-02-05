package HarshTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChars {
    /**
     * 因为总共有26个字母
     * 创建一个容量为26的数组array来放一个String数组元素中出现的字母的次数
     * 接着遍历整个数组，每次遍历要比较新元素和旧元素中出现字母的次数
     * array只存放目前出现次数最少的情况
     * 当遍历整个String数组后，array就是最终的常用字符出现次数的数组，在进行char转换即可
     * */
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c : A[0].toCharArray()){
            res[c - 'a']++;
        }

        for (int i = 1;i < A.length;i++){
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()){
                temp[c - 'a']++;
            }

            for (int j = 0;j < 26;j++){
                res[j] = Math.min(res[j], temp[j]);
            }
        }

        for (int i = 0;i < 26;i++){
            if (res[i] > 0){
                for (int j = 0;j < res[i];j++){
                    list.add(i + 'a' + "");
                }
            }
        }

        return list;
    }
}
