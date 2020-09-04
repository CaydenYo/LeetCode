package BinaryTree;

import java.util.*;

public class LowestCommonAncestor {
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root,p , q);
        return ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q){
        // if reach the end of a branch, return false
        if (currentNode == null){
            return false;
        }
        // left recursion. if left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // right recursion.
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // if the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if (mid + left + right >= 2){
            this.ans = currentNode;
        }

        // return true if any one of the three bool values is true.
        return (mid + left + right > 0);
    }



    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // hashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            // while traversing the tree, keep saving the parent pointers
            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // process all ancestors for node p using parent pointers
        while (p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        // the first ancestor of q which appears in p's ancestors is their lowest common ancestor.
        while (!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }
}
