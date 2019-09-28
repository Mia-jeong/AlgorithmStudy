package leetcode.easy;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];

        int storage[] = new int[nums.length];
        storage[0] = nums[0];
        storage[1] = nums[1];

        if(nums.length == 2) return Math.max(storage[0], storage[1]);
        storage[2] = nums[2]+nums[0];

        int max = Math.max(storage[1], storage[2]);

        for (int i = 3; i < nums.length; i++) {
            storage[i] = nums[i] + Math.max(storage[i-2], storage[i-3]);
            if(storage[i] > max) max = storage[i];
        }
        return max;
    }
}
