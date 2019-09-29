package leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConvertSortedArrayToBinarySearch {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return makeBST(nums, 0, nums.length-1);
    }
    public TreeNode makeBST(int[] nums , int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        if(start+1 == end ) mid = end;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left = makeBST(nums, start, mid-1);
        tree.right = makeBST(nums,mid+1, end);
        return tree;
    }
}
