package BinarySearchTree;

import java.util.PriorityQueue;

public class KthLargestPriorityQueue703 {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestPriorityQueue703(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>(k);
        for(int i: nums) {
            add(i);
        }
    }

    public int add(int val) {
        if(pq.size() < k) {
            pq.offer(val);

        }
        else if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
