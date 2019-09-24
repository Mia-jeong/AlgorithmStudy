package leetcode.easy;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int num = nums.length > 0 ? nums[0] : -1;
        int maxNum = -1;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == num){
                count += 1;
                if(maxCount < count) {
                    maxCount = count;
                    maxNum = nums[i];
                }
            }else{
                count = 1;
                num = nums[i];
            }
        }
        return maxNum;

    }
    //solution in discussion
    //the problem said that the majority element appears more than n/2 times
    public int majorityElement2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len/2];
    }
}
