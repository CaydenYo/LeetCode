package ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CopyRandomList138Recursion {
    // HashMap which holds old nodes as keys and new nodes as its value
    HashMap<Node, Node> visitedHash = new HashMap<>();
    public Node copyRandomList(Node head) {
       if (head == null){
           return null;
       }
       // If we have already processed the current node, then we simply return the cloned version
       if (this.visitedHash.containsKey(head)){
           return this.visitedHash.get(head);
       }

       // Create a new node with the value same as old node.
       Node node = new Node(head.val);

       // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid them
       this.visitedHash.put(head, node);

       node.next = this.copyRandomList(head.next);
       node.random = this.copyRandomList(head.random);

       return node;
    }
}
