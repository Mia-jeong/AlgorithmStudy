package leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int result[] = new int[m+n];
        int p = 0, q = 0;
        int idx = 0;
        while(p < m && q < n){
            if(nums1[p] < nums2[q]){
                result[idx++] = nums1[p++];
            }else if (nums1[p] > nums2[q]){
                result[idx++] = nums2[q++];
            }else {
                result[idx++] = nums1[p++];
                result[idx++] = nums2[q++];
            }
        }
        if(p < m) {
            for (int i = p; i < m; i++) result[idx++] = nums1[i];
        }else if(q < n){
            for (int i = q; i < n; i++) result[idx++] = nums2[i];
        }
        for (int i = 0; i < result.length; i++) nums1[i] = result[i];
    }

    //solution in discussion
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for(int i =0;i < n;i++){
            nums1[m] = nums2[i];
            m++;
        }
        Arrays.sort(nums1);
    }
}
