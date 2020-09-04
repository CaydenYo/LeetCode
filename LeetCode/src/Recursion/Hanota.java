package Recursion;

import java.util.List;

/**
 * @Author cayden
 * @Date 2020/7/17 10:31 下午
 */
public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C){
        move(A.size(), A, B, C);
    }

    private void move(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (size == 1){
            c.add(a.remove(a.size() - 1));
            return;
        }
        move(size - 1, a, c, b); // 将a上面n - 1个移到b
        c.add(a.remove(a.size() - 1)); // 将a最后一个元素移到c
        move(size - 1, b, a, c); // 将b上的n - 1个全部移动c
    }
}
