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


    // two pointers
    public int[] intersection2(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        int p1 = 0; // nums1的指针
        int p2 = 0; // nums2的指针
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;                   //需可保证下次比较的产生结果的可能性
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                set.add(nums1[p1]);     //可作为交集的一部分
                p1++;
                p2++;
            }
        }
        p1 = 0;
        int[] resArr = new int[set.size()]; //set的元素即为交集
        for(int n : set) {
            resArr[p1++] = n;
        }
        return resArr;
    }

    // binary search
    public int[] intersection3(int[] nums1, int[] nums2){
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i < nums1.length;i++){
            if (binarySearch(nums2, nums1[i])){
                set.add(nums1[i]);
            }
        }
        int p = 0;
        int[] res = new int[set.size()];
        for (int item : set){
            res[p++] = item;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left);
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
