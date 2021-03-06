import java.util.Arrays;

public class MergeSort {
    public MergeSort(int[] array){
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边的数组进行递归
        sort(array, left, center);
        // 对右边的数组进行递归
        sort(array, center + 1, right);
        // 合并
        merge(array, left, center, right);
    }

    private void merge(int[] array, int left, int center, int right){
        // 临时数组
        int[] tempArray = new int[array.length];
        // 右数组第一个元素索引
        int r1 = center + 1;
        // 记录临时数组的索引
        int tempIndex = left;
        // 缓存左数组第一个元素的索引
        int l1 = left;
        while (left <= center && r1 <= right){
            // 从两个数组中取出最小的放入临时数组
            if (array[left] <= array[r1]){
                tempArray[tempIndex++] = array[left++];
            }else {
                tempArray[tempIndex++] = array[r1++];
            }
        }

        // 将剩余部分一次放入临时数组（实际两个while只会执行其中一个）
        while (r1 <= right){
            tempArray[tempIndex++] = array[r1++];
        }
        while (left <= center){
            tempArray[tempIndex++] = array[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (l1 <= right){
            array[l1] = tempArray[l1++];
        }
    }

    public int [] merge_sort(int [] input) {
        if (input.length <= 1) {
            return input;
        }
        int pivot = input.length / 2;
        int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
        int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left_list, right_list);
    }

    public int [] merge(int [] left_list, int [] right_list) {
        int [] ret = new int[left_list.length + right_list.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

        while (left_cursor < left_list.length &&
                right_cursor < right_list.length) {
            if (left_list[left_cursor] < right_list[right_cursor]) {
                ret[ret_cursor++] = left_list[left_cursor++];
            } else {
                ret[ret_cursor++] = right_list[right_cursor++];
            }
        }
        // append what is remain the above lists
        while (left_cursor < left_list.length) {
            ret[ret_cursor++] = left_list[left_cursor++];
        }
        while (right_cursor < right_list.length) {
            ret[ret_cursor++] = right_list[right_cursor++];
        }
        return ret;
    }

    public static void main(String[] args){
        int[] array = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        MergeSort ms = new MergeSort(array);
        for (int item : array){
            System.out.print(item + " ");
        }
    }
}
