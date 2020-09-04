package BinaryTree;

public class Connect117 {
    /*
    * 核心是getNextNoNullChild，根据root，找到下一级右手第一个
    * 然后分情况讨论，对每个节点：
    * 左子右子都有，则左子next指向右子，右子next指向getNextNoNullChild
    * 只有左子，左子指向getNextNoNullChild，
    * 只有右子，右子指向getNextNoNullChild，
    * 注意：递归时要先递归右子树，否则上级节点next关系没建好，下级无法成功getNextNoNullChild
    * */
    public Node connect1(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect1(root.right);
        root.left = connect1(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static Node getNextNoNullChild(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }

    public Node connect2(Node root){
        if (root == null){
            return root;
        }
        Node pre = root;
        Node cur = null;
        while (true){
            cur = pre;
            while (cur != null){
                // 找到至少有一个孩子的节点
                if (cur.left == null && cur.right == null){
                    cur = cur.next;
                    continue;
                }
                // 找到当前节点的下一个至少有一个孩子的节点
                Node next = cur.next;
                while (next != null && next.left == null && next.right == null){
                    next = next.next;
                    if (next == null){
                        break;
                    }
                }
                // 当前节点的左右孩子都不为空，就将left.next指向right
                if (cur.left != null && cur.right != null){
                    cur.left.next = cur.right;
                }
                // 要接上next的节点的孩子，所以用temp处理当前节点right为null的情况
                Node temp = cur.right == null ? cur.left : cur.right;
                if (next != null){
                    // next左孩子不为null, 就接上左孩子
                    if (next.left != null){
                        temp.next = next.left;
                    }else {
                        temp.next = next.right;
                    }
                }
                cur = cur.next;
            }
            // 找到拥有孩子的节点
            while (pre.left == null && pre.right == null){
                pre = pre.next;
                // 都没有孩子说明已经是最后一层了
                if (pre == null){
                    return root;
                }
            }
            // 进入下一层
            pre = pre.left != null ? pre.left : pre.right;
        }
    }

}
