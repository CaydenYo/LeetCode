package LinkedList;

import java.util.Stack;

public class Flatten430 {
    public Node flatten1(Node head) {
        if (head == null){
            return head;
        }
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    private Node flattenDFS(Node prev, Node curr){
        if (curr == null){
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;

        Node tmpNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tmpNext);
    }

    // the process is like the preorder iteration of binary tree
    // child is the left subtree and next is the right subtree
    public Node flatten2(Node head) {
        if (head == null){
            return head;
        }
        Node pseudoHead = new Node(0, null, head, null);

        Node prev = pseudoHead;
        Node curr = pseudoHead;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()){
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null){
                stack.push(curr.next);
            }
            if (curr.child != null){
                stack.push(curr.child);
                curr.child = null;
            }

            prev = curr;
        }

        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public Node flatten3(Node head){
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            // has child
            if (cur.child != null) {
                // maintain next node
                Node next = cur.next;
                // connect flatten node list
                Node child = flatten3(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                // connect original next node
                if (next != null) {
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }



    public Node flatten4(Node head){
        if (head == null){
            return null;
        }
        Node curr = head;
        while (curr != null){
            if (curr.child != null){
                Node tmpNext = curr.next;
                Node child = flatten4(curr.child);
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                if (tmpNext != null){
                    while (curr.next != null){
                        curr = curr.next;
                    }
                    curr.next = tmpNext;
                    tmpNext.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }

}
