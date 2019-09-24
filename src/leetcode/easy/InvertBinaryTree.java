package leetcode.easy;

public class InvertBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode copy = new TreeNode(root.val);
        copy.left = invertTree(root.right);
        copy.right = invertTree(root.left);
        return copy;
    }
}
