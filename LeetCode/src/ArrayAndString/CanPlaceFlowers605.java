package ArrayAndString;

/**
 * @Author cayden
 * @Date 2020/8/23 11:12 下午
 */
public class CanPlaceFlowers605 {
    /**
     * 关键：只要连续出现3个0即表示前面可以种下一束花
     * 但是存在左右边界问题，可以假设在数组左边添加0，
     * 因此初始的count为1
     * */
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        int num = 0, count = 1;
        for (int i = 0;i < flowerbed.length;i++){
            if (flowerbed[i] == 0){
                count++;
            }else {
                count = 0;
            }

            if (count == 3){
                num++;
                count = 1;
            }
        }

        if (count == 2){
            num++;
        }

        return n <= num;
    }
}
