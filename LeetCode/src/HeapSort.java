public class HeapSort {
    public HeapSort(int[] array){
        // 将待排序的序列构建成一个大顶堆
        for (int i = array.length / 2;i >= 0;i--){
            heapAdjust(array, i, array.length);
        }
        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = array.length - 1;i > 0;i--){
            swap(array, 0, i);// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(array, 0, i);
        }
    }

    /*
    * array 需要排序的数组
    * i 需要构建堆的根节点的序号
    * n 数组的长度
    * */
    private void heapAdjust(int[] array, int i, int length) {
        int child;
        int father;
        for (father = array[i];leftChild(i) < length;i = child){
            child = leftChild(i);
            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != length - 1 && array[child] < array[child + 1]){
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子节点，则需要交换
            if (father < array[child]){
                array[i] = array[child];
            }else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        array[i] = father;
    }

    // 获取到左孩子结点
    private int leftChild(int i){
        return 2 * i + 1;
    }

    // 交换元素位置
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args){
        int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
        HeapSort hs = new HeapSort(arr);
        for (int item : arr){
            System.out.print(item + " ");
        }
    }
}
