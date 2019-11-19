package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<Integer>();
        inorder(root, nodes);
        return nodes.get(k-1);
    }

    public void inorder(TreeNode node, List<Integer> nodes){

        if(node == null) return;
        inorder(node.left, nodes);
        nodes.add(node.val);
        inorder(node.right, nodes);
    }

    //solution
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(true){
            while(root != null){
                stack.add(root);
                root =root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
    /*
       input: [5, 3, 6, 2, 4, null, 7], k = 5
       stack: 5, 3, 2
       stack after removeLast = 5, 3
       root after removeLast = 2
       root assigned by root.right = null
       k  4

       stack: 5, 3
       stack after removeLast = 5
       root after removeLast = 3
       root assigned by root.right = 4
       k  3

       stack: 5, 4
       stack after removeLast = 5
       root after removeLast = 4
       root assigned by root.right = null
       k  2

       stack: 5
       stack after removeLast = []
       root after removeLast = 5
       root assigned by root.right = 6
       k  1

       stack: 6
       stack after removeLast = []
       root after removeLast = 6
       root assigned by root.right = 7
       k  0

     */
}
