package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        recursive(list, root, 0);
        return list;
    }

    public static void recursive(List<List<Integer>> list, TreeNode node, int level){
        if(node == null) return;
        if(list.size() <= level) {
            list.add(new LinkedList<>());
        }

        list.get(level).add(node.val);
        recursive(list, node.left, level+1);
        recursive(list, node.right, level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list =levelOrder(root);
    }
}
