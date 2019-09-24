package leetcode.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - (i+1); j++) {
                int curr = nums[j];
                int next = nums[j+1];
                if(curr != 0) continue;

                nums[j] = next;
                nums[j+1] = 0;
            }
        }
    }

    //discussion O(n)
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
    //j points to zero right next to number. so if there's number it should be swapped to the index of j.
}
