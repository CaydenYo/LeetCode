package TwoPointers;

public class Merge {
    public void preMerge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0; // nums1_copy
        int p2 = 0; // nums2

        int p = 0; // nums1

        while (p1 < m && p2 < n){
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        if (p1 < m){
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n){
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public void postMerge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        // 因为nums1已经在里面了，我们只需补齐nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public void merge(int[] A, int m, int[] B, int n) {
        int cur = m + n - 1;
        int parseA = m - 1;
        int parseB = n - 1;

        while (parseA >= 0 && parseB >= 0){
            if(A[parseA] >= B[parseB]){
                A[cur--] = A[parseA];
                parseA--;
            }else{
                A[cur--] = B[parseB];
                parseB--;
            }
        }

        if(parseA >= 0){
            for(int i = parseA;i >= 0;i--){
                A[cur--] = A[i];
            }
        }

        if(parseB >= 0){
            for(int i = parseB;i >= 0;i--){
                A[cur--] = B[i];
            }
        }
    }

    public static void main(String[] args){
        int[] A = {0};
        int[] B = {1};
        new Merge().merge(A,0,B,1);
    }
}
