package Hot100;

/**
 * @Author cayden
 * @Date 2020/6/27 4:04 下午
 */
public class CanJump55 {
    /**
     * 1. 如果某一个作为起跳点可以跳跃的距离为x，那么表示后面x个鸽子都可以作为起跳点
     * 2. 对每一个能作为起跳点的格子都尝试跳一遍，把能跳到最远的距离更新
     * 3. 如果可以跳到最后就成功
     * */
    public boolean canJump(int[] nums){
        int canJumpMax = 0;
        for (int i = 0;i < nums.length;i++){
            if (i > canJumpMax){
                return false;
            }
            canJumpMax = Math.max(canJumpMax, canJumpMax + nums[i]);
            if (canJumpMax >= nums.length - 1){
                return true;
            }
        }
        return true;
    }


}
