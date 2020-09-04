package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cayden
 * @Date 2020/8/7 3:28 下午
 */
public class LevelOrder429 {
    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < count;i++){
                Node1 node = queue.poll();
                list.add(node.val);
                for(Node1 item : node.children){
                    queue.add(item);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Node1 n1 = new Node1(1);
        List<Node1> list = new ArrayList<>();
        list.add(new Node1(3));
        list.add(new Node1(2));
        list.add(new Node1(4));
        n1.children = list;
        List<Node1> list1 = new ArrayList<>();
        list1.add(new Node1(5));
        list1.add(new Node1(6));
        n1.children.get(0).children = list1;

        new LevelOrder429().levelOrder(n1);
    }
}
