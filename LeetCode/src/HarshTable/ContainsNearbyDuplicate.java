package HarshTable;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public ContainsNearbyDuplicate(int[] nums, int k){
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0;i < nums.length;i++){
            if (hashSet.contains(nums[i])){
                return true;
            }
            hashSet.add(nums[i]);
            if (hashSet.size() > k){
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
