package BinarySearch;

public class SplitArray410 {
    private int ans;
    private int n, m;

    private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax){
        if (i == n && cntSubarrays == m){
            ans = Math.min(ans, curMax);
            return;
        }
        if (i == n){
            return;
        }
        if (i > 0){
            dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curMax, curSum + nums[i]));
        }
        if (cntSubarrays < m){
            dfs(nums, i + 1, cntSubarrays + 1, nums[i], Math.max(curMax, nums[i]));
        }
    }


    // binary search
    public int splitArrayBinarySearch(int[] nums, int m){
        int low = nums[0];
        int high = 0;
        for (int i : nums){
            high += i;
            low = low > i ? low : i;
        }

        while (low < high){
            int mid = low + (high - low) / 2;
            int temp = 0;
            int count = 1;
            for (int i : nums){
                temp += i;
                if (temp > mid){
                    temp = i;
                    count++;
                }
            }
            if (count <= m){
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }



    public int splitArray(int[] nums, int M){
        ans = Integer.MAX_VALUE;
        n = nums.length;
        m = M;
        dfs(nums, 0, 0, 0, 0);
        return ans;
    }
}
