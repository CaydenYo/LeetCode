package TwoPointers;

public class MinSubArrayLen {
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                int sum = 0;
                for (int k = i;k <= j;k++){
                    sum += nums[k];
                }
                if (sum >= s){
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0;i < n;i++){
            sum += nums[i];
            while (sum >= s){
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
