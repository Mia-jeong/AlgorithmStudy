package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    public void inOrder (TreeNode root){
        if(root == null) return;
        else {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }

    //solution 1in discussion using Stack
    /*
            1
           /  \
          2    3
         /\   /
        4  5 6

    */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!= null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
    //solution2 in discussion using Moris Travelsal
    /*
            1
           /  \
          2    3
         /\   /
        4  5 6

         2
        / \
       4   5
            \
             1
              \
               3
              /
             6

        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6
    */

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while(curr != null) {
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{

                pre = curr.left;
                while(pre.right != null) pre = pre.right;
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return list;
    }

}
