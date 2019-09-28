package leetcode.easy;

/*
to do: I heard there's a way to solve it using divide and conquer, I should figure it out.
*/
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0 ) return 0;
        int storage[] = new int[nums.length];
        storage[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = storage[i -1]+ nums[i];
            if(nums[i] > temp) storage[i] = nums[i];
            else storage[i] = temp;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] > max) max = storage[i];
        }
        return max;
    }

}
