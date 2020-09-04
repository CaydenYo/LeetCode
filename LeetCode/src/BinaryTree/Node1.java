package BinaryTree;

import java.util.List;

/**
 * @Author cayden
 * @Date 2020/8/7 3:27 下午
 */
public class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
}
