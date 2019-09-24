package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> storage = new LinkedList<>();
        if(nums.length > 0){
            Arrays.sort(nums);
            int n = 1;
            for (int i = 0; i < nums.length; i++) {
                int t = nums[i];
                if(t == n) n++;
                if(t > n){
                    for (int j = n; j < t; j++) {
                        storage.add(j);
                    }
                    n = t+1;
                }
            }

            if(n != nums[nums.length-1]){
                for (int i = n; i <= nums.length; i++) {
                    storage.add(i);
                }
            }


        }
        return storage;
    }

    //the best solution I think in discussion
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
    //ex) if 4 exists, turn num[3] into minus value, if 5 exists, turn num[4] into minus value
    // after it,  while looping through array again, figure out the index of array which has not minus number,
    // it means it has no value of it in the array.

}
