package leetcode.easy;

public class MaximumDepthOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + (l>= r? l : r);
    }
    /*
    Firstly, if the root is null then return 0.
            if it's not, figure out both what is the left depth of the node and what is the right depth of the node.
    Secondly, to avoid duplicate count, figure out which is the max between left of depth and right of depth
    Finally return 1 + maxValue!

    It's going to search every node in tree. so it's going to be linear search and take O(n) !
    */
}
