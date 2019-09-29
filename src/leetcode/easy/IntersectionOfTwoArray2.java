package leetcode.easy;


import java.util.*;

public class IntersectionOfTwoArray2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.get(nums1[i]) == null) map.put(nums1[i], 1);
            else map.replace(nums1[i], map.get(nums1[i])+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(map.get(nums2[i]) == null || map.get(nums2[i]) <= 0) continue;
            else {
                map.put(nums2[i], map.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }

        int result[] = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
