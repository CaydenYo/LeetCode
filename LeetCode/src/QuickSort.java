public class QuickSort {
    public QuickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        int p; // 基准数，一般是每个数组的第一个
        int i, j, temp;
        if (low >= high){
            return;
        }
        p = arr[low];
        i = low;
        j = high;
        while (i < j){
            // 当右边发现小于小于p的值时停止循环
            while (arr[j] >= p && i < j){
                j--;
            }
            // 一定是右边开始，上下这两个循环不能调换
            // 左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j){
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, j-1); // 对左边快排
        quickSort(arr, j+1, high); // 对右边快排
    }

    public static void main(String[] args){
        int[] array = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        QuickSort qs = new QuickSort(array);
        for (int item : array){
            System.out.print(item + " ");
        }
    }
}
