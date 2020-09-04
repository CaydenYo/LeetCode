package BinarySearch;

/**
 * @Author cayden
 * @Date 2020/8/15 3:08 下午
 */
public class HIndex275 {
    /**
     * 找一个mid，从mid开始到最后的文章数记为paperCnt，
     * 这些paper的最低引用数量大于等于paperCnt，
     * 那么我们只看最低的引用数量是否大于paperCnt，
     * 也就是只看citation[mid]是不是大于等于paperCnt就行了。
     * */
    public int hIndex(int[] citations){
        int len = citations.length;
        int low = 0, high = len - 1;
        int mid;
        int res = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            int paperCnt = len - mid;
            // len - mid 代表从mid到len到论文数量，若想len - mid作为hIndex
            // 则要求从mid到len中最低引用的那篇论文的citations就大于等于len - mid（也就是citations[mid]>=paperCnt）。
            // 若满足这个条件，我们尝试能不能让hIndex更大些，也就是mid往左一些，那么我们就调整end = mid - 1
            // 若条件不满足，我们让mid向右面移动，这样paperCnt就少了，同时citations[mid]也大了，我们再看看从mid开始到len能不能作为hIndex
            if (paperCnt <= citations[mid]){
                res = paperCnt;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return res;
    }
}
