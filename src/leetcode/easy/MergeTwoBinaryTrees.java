package leetcode.easy;

public class MergeTwoBinaryTrees {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }



    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null)return null;
        if(t1 ==null) return t2;
        if(t2 ==null) return t1;
        TreeNode newTree = new TreeNode(t1.val+t2.val);
        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t2.right);

        return newTree;
    }

}
