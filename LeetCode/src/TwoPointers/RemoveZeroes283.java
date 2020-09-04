package TwoPointers;

public class RemoveZeroes283 {
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        // record the numbers of non-zero number
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        // make the rest of array 0
        for (int i = j;j < nums.length;j++){
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        // record the numbers of non-zero number
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            // if element != 0, then switch it to the left, otherwise right.
            if (nums[i] != 0){
                // avoid duplicated operation when i == j
                if (i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
