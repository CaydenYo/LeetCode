package HarshTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length;i++){
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length;i++){
            set2.add(nums2[i]);
        }

        if (set1.size() < set2.size()){
            return set_intersection(set1, set2);
        }else {
            return set_intersection(set2, set1);
        }


    }

    private int[] set_intersection(Set<Integer> set1, Set<Integer> set2){
        int[] res = new int[set1.size()];
        int idx = 0;
        for (Integer i : set1){
            if (set2.contains(i)){
                res[idx++] = i;
            }
        }
        return Arrays.copyOf(res, idx);
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length;i++){
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length;i++){
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);
        int index = 0;
        int[] res = new int[set1.size()];
        for (Integer s : set1){
            res[index++] = s;
        }
        return res;


    }
}
