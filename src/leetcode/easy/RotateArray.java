package leetcode.easy;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int copy[] = nums.clone();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int idx = (k+i) % len;
            nums[idx] = copy[i];
        }
    }
}
