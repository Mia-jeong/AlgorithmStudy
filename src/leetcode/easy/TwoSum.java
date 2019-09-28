package leetcode.easy;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // [8,7,11,15], 19
    // stores all data to hash map with their index.
    // [{8:0},{7:1},{11:2},{15:3}]
    // 19-8 == 11 < 11 exists in hashmap
    // so it can return 0, 2
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target-nums[i];
            Integer mapVal = map.get(diff);
            if(mapVal!= null && mapVal!= i) return new int[] {i, mapVal};
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target-nums[i];
            Integer mapVal = map.get(diff);
            if(mapVal!= null ) return new int[] {Math.min(i, mapVal), Math.max(i,mapVal)};
            else map.put(nums[i], i);
        }
        return null;
    }


}
