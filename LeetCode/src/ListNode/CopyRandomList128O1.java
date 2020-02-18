package ListNode;

public class CopyRandomList128O1 {
    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }

        // Create a new weaved list of original and copied nodes.
        Node ori = head;
        while (ori != null){
            // Cloned node
            Node newNode = new Node(ori.val);
            newNode.next = ori.next;
            ori.next = newNode;
            ori = newNode.next;
        }

        ori = head;

        // Now link the random pointers of the new nodes
        // Iterate the newly created list and use the original nodes' random

        while (ori != null){
            ori.next.random = (ori.random == null) ? null : ori.random.next;
            ori = ori.next.next;
        }

        // Unweave the linked list to get back the original linked list and the new one
        Node origin = head;
        Node newList = head.next;
        Node newHead = head.next;
        while (origin != null){
            origin.next = origin.next.next;
            newList.next = (newList.next == null) ? null : newList.next.next;
            origin = origin.next;
            newList = newList.next;
        }

        return newHead;
    }
}
