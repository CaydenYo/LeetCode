package ArrayAndString;

public class Rotate {
    public void rotate(int[] nums, int k) {
        // k can be bigger than nums.length
        k = k % nums.length;
        int count = 0;
        for (int start = 0;count < nums.length;start++){
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotate2(int[] nums, int k) {
        // k can be bigger than nums.length
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = end;
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
