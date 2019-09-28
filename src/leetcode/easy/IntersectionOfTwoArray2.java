package leetcode.easy;

import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArray2 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int prevIndex = -1;
        for (int i = 0; i < nums2.length; i++) {
            Integer temp = map.get(nums2[i]);
            if(temp!= null){
                if(prevIndex == -1){
                    prevIndex = temp;
                }
                else{
                    if(temp - prevIndex == 1){
                        prevIndex = temp;

                    }else {

                    }
                }
            }
        }
        return null;

    }
}
