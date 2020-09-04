package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/25 8:51 下午
 */
public class IsOneBitCharacter717 {
    public boolean isOneBitCharacter(int[] bits){
        int pre = 0;
        int curr = 0;
        while (curr < bits.length){
            if (curr != 0){
                pre = curr;
            }
            if (bits[curr] == 1){
                curr += 2;
            }else {
                curr++;
            }

        }
        return curr == pre + 1;
    }

    /**
     * 数组一定以0结尾
     * 所以可以计算在0前面有多少个连续的1
     * 如果是奇数，证明还有一个1没法匹配，只能和0匹配
     * 如果是偶数，则前面的1都可以两两配对，最后的0就是one bit
     * */
    public boolean isOneBitCharacter1(int[] bits) {
        int ones = 0;
        //Starting from one but last, as last one is always 0.
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
            ones++;
        }
        if (ones % 2 > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0};
        System.out.println(new IsOneBitCharacter717().isOneBitCharacter(nums));
    }
}
