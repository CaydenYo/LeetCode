package BinarySearchTree;

public class KthLargest703 {

    private class BST{
        private class Node{
            private int val;
            private int count = 1;
            private Node left;
            private Node right;

            Node(int x){
                val = x;
            }
        }

        private Node root;

        public void add(int val){
            root = add(root, val);
        }

        private Node add(Node root, int val){
            if (root == null){
                return new Node(val);
            }
            // insert into right subtree
            if (val > root.val){

                root.right = add(root.right, val);
            }else if (val < root.val){
                root.left = add(root.left, val);
            }
            // duplicated value
            root.count++;
            return root;
        }

        public Node search(int k){
            return search(root, k);
        }

        private Node search(Node root, int k){
            if (root == null){
                return root;
            }
            int leftNodeCount = root.left != null ? root.left.count : 0;
            int rightNodeCount = root.right != null ? root.right.count : 0;
            int currNodeCount = root.count - leftNodeCount - rightNodeCount;
            if (k > currNodeCount + rightNodeCount){
                return search(root.left, k - currNodeCount - rightNodeCount);
            }else if (k <= rightNodeCount){
                return search(root.right, k);
            }else{
                return root;
            }
        }
    }


    private int k;
    private BST bst = new BST();

    public KthLargest703(int k, int[] nums) {
        this.k = k;
        for (int num : nums){
            bst.add(num);
        }
    }

    public int add(int val) {
        bst.add(val);
        return bst.search(k).val;
    }



}
