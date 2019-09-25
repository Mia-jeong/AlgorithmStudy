package leetcode.easy;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1] > 1){
                return nums[i]-1;
            }
        }
        return 0;
    }
    //best solution in discussion
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        // 4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
        //(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
        // 0^0^0^0^2
        //2
        return missing;
    }
}
