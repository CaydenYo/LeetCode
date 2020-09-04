package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connect116 {
    public Node connect1(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                Node node = queue.poll();
                if (count > 1){
                    node.next = queue.peek();
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
        }
        return root;
    }

    public Node connect2(Node root){
        if(root == null){
            return root;
        }

        Node leftmost = root;
        while (leftmost.left != null){
            Node head = leftmost;
            while (head != null){
                // connection 1
                head.left.next = head.right;

                // connection 2
                if (head.next != null){
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    // recursion
    public Node connect3(Node root){
        if (root != null){
            helper(root.left, root.right);
        }
        return root;
    }

    private void helper(Node left, Node right){
        if (left != null){
            left.next = right;
            helper(left.left, left.right);
            helper(left.right, right.left);
            helper(right.left, right.right);
        }
    }
}
