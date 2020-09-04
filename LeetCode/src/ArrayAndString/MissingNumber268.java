package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/21 9:51 下午
 */
public class MissingNumber268 {
    /**
     * 我们知道数组中有 n 个数，并且缺失的数在 [0..n] 中。
     * 因此我们可以先得到 [0..n] 的异或值，再将结果对数组中的每一个数进行一次异或运算。
     * 未缺失的数在 [0..n] 和数组中各出现一次，因此异或后得到 0。
     * 而缺失的数字只在 [0..n] 中出现了一次，在数组中没有出现，因此最终的异或结果即为这个缺失的数字
     * */
    public int missingNumber(int[] nums){
        int missing = nums.length;
        for (int i = 0;i < nums.length;i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 在线性时间内可以求出数组中所有数的和
     * 并在常规时间内求出前n + 1个自然数的和
     * 将后者减去前者，就可以得到缺失的数字
     *
     * 但是可以在把0-n这n + 1个自然数全加起来的同时也减去nums[i]
     * 这样可以防止数据溢出
     * */
    public int missingNumber1(int[] nums){
        int sum = 0;
        for (int i = 1; i <= nums.length;i++){
            sum += i;
            sum -= nums[i - 1];
        }

        return sum;
    }
}
