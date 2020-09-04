package LinkedList;

/**
 * @Author cayden
 * @Date 2020/7/26 9:01 下午
 */
public class SplitListToParts725 {
    /**
     * 类似抽屉原理：
     * 先统计总共有多少个元素count
     * 再用count / k得到每个抽屉至少要放多少个元素
     * 再用count % k得到有多少个抽屉需要额外多放一个元素
     * */
    public ListNode[] splitListToParts(ListNode root, int k){
        ListNode[] res = new ListNode[k];
        ListNode curr = root;
        int count = 0;
        while (curr != null){
            count++;
            curr = curr.next;
        }
        int num = count / k;
        int extra = count % k;
        curr = root;
        for (int i = 0;i < k && curr != null;i++){
            res[i] = curr;
            for (int j = 1;j < num + (i < extra ? 1 : 0);j++){
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return res;
    }
}
