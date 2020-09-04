package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    public List<Integer> sortArray(int[] nums) {
        if (nums.length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }
        if (nums.length == 0){
            return null;
        }
        int pivot = nums.length / 2;
        List<Integer> left_list = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        List<Integer> right_list = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));

        return merge(left_list, right_list);
    }

    private List<Integer> merge(List<Integer> left_list, List<Integer> right_list) {
        List<Integer> ret = new ArrayList<>();
        int left_cursor = 0, right_cursor = 0;
        while (left_cursor < left_list.size() && right_cursor < right_list.size()){
            if (left_list.get(left_cursor) < right_list.get(right_cursor)){
                ret.add(left_list.get(left_cursor++));
            }else {
                ret.add(right_list.get(right_cursor++));
            }
        }

        while(left_cursor < left_list.size()){
            ret.add(left_list.get(left_cursor++));
        }

        while(right_cursor < right_list.size()){
            ret.add(right_list.get(right_cursor++));
        }

        return ret;
    }

    public static void main(String[] args){
        int[] nums = {5,2,3,1};
        for (Integer i : new SortArray().sortArray(nums)){
            System.out.println(i);
        }
    }
}
