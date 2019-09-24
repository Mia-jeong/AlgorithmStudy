package leetcode.easy;

import java.util.Arrays;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(num == nums[i]) count++;
            if(num != nums[i] && count != 1) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }

    /*

    Firstly, sort the array.
    Secondly, make 2 variables to store num and count of the num.
    Finally, loop the array to figure out the data which exists once.

    it's going to search the entire array. so it's linear search and take O(n)
    */
}
