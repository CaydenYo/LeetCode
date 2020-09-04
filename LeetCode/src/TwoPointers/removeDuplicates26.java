package TwoPointers;

public class removeDuplicates26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int mark = 0;
        int cur = 1;
        while(cur <= nums.length - 1){
            if (nums[mark] != nums[cur]){
                nums[++mark] = nums[cur];
            }
            cur++;
        }
        return mark + 1;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
