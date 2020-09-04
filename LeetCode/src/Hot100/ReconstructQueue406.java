package Hot100;

import java.util.*;

/**
 * @Author cayden
 * @Date 2020/7/12 5:19 下午
 */
public class ReconstructQueue406 {

    /**
     * 按高度降序排序
     * 同一高度的人，按k值的升序排序
     * 这样我们就提前把高的人排好了
     * 然后逐个把它们放到输出队列中，索引等于它们的k值
     * 这样做的原因是，矮的人相对于高的人来说是看不见的，例如
     * 目前输出队列里面已经有[7,0],[7,1]两个数
     * 如果在这两个数之中插入任意个矮的人，对于[7,1]来说，比它高的永远只有[7,0]
     * 所以在已经排好的高序列中插入矮的人不会破坏k的条件
     * */
    public int[][] reconstructQueue(int[][] people){
        //两数不等，按照左边数降序，两边相等，按照右边数升序
        Arrays.sort(people,(o1,o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int []> list =  new LinkedList<>();
        for(int [] p :people){
            // 把p加到p[1]下标为右边数的位置
            // 高个子先站好位，矮个子插入到k位置上，前面肯定有k个高个子，矮个子再插到前面也满足k的要求
            list.add(p[1],p);
        }
        // 返回新数组，注意设置长度 几行2列
        return list.toArray(new int[list.size()][2]);
    }

    public int[][] reconstructQueue1(int[][] people){
        int len = people.length;
        if (len <= 1){
            return people;
        }
        List<Integer> position = new ArrayList<>();
        for (int i = 0;i < len;i++){
            position.add(i);
        }
        int[][] res = new int[len][2];
        for (int i = 0;i < len;i++){
            for (int j = 0;j < 2;j++){
                res[i][j] = people[i][j];
            }
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        for (int[] item : people){
            int pos = position.get(item[1]);
            position.remove(item[1]);
            res[pos][0] = item[0];
            res[pos][1] = item[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new ReconstructQueue406().reconstructQueue(people);
    }
}
