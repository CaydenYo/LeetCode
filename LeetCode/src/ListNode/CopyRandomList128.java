package ListNode;

import java.util.HashMap;

public class CopyRandomList128 {
    HashMap<Node, Node> visited = new HashMap<>();

    public Node getClonedNode(Node node){
        // If the node exist then
        if (node != null){
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)){
                // If it is in the visited dictionary then return new node reference
                return this.visited.get(node);
            }else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }

        Node oldNode = head;
        // Create the new head node.
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned
        while (oldNode != null){
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return this.visited.get(head);
    }
}
