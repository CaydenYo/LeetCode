public class InsertionSort {
    public int[] sort(int[] array){
        int i = 0;
        int j = 0;
        int temp = 0;
        for (i = 1;i < array.length;i++){
            temp = array[i]; //从待插入组取出第一个元素
            j = i - 1; //i - 1为有序组最后一个元素(与待插入元素相邻)的下标
            //注意判断条件为两个，j >= 0对其进行辩解限制。第二个为插入判断条件
            while (j >= 0 && temp < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
    public static void main(String args[]){
        InsertionSort is = new InsertionSort();
        int[] array = {9,3,4,2,6,7,5,1,8};
        array = is.sort(array);
        for (int item:array){
            System.out.print(item + " ");
        }
    }
}
