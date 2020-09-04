package Hot100;

import java.util.HashMap;

/**
 * @Author cayden
 * @Date 2020/7/2 6:14 下午
 */

/**
 * cache必须要有顺序之分，以区分最近使用的和久未使用的数据
 * 哈希表查找快，但是数据无固定顺序
 * 链表有顺序之分，插入删除快，但是查找慢
 * 所以结合两者形成新的数据结构：哈希链表
 *
 * 简单来说就是
 * 当我们想对链表做操作时，我们先询问哈希表这个key是否存在于缓存中
 * 如果存在，则直接从哈希表中获取node
 * 这样直接跳过了在链表中循环查找这个node的步骤
 * 变相赋予了链表快速查询的特性
 * */
public class LRUCache146 {
    class Node{
        public int key, val;
        public Node next, prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    class DoubleList{
        private Node head, tail;
        private int size;

        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x){
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeLast(){
            if (tail.prev == head){
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size(){
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache146(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }else {
            int val = map.get(key).val;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        }else {
            if (cap == cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
