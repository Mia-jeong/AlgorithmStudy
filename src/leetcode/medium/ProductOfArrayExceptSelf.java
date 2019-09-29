package leetcode.medium;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        //       1  2  3  4
        //temp 1 1  1  2  6
        //temp 2 24 12 4  1
        int temp1[] = new int[nums.length];
        int temp2[] = new int[nums.length];
        int result[] = new int[nums.length];
        int n = 1;
        temp1[0] = 1;
        for (int i = 0; i < nums.length-1; i++) {
            temp1[i+1] = nums[i] * temp1[i];
        }
        temp2[nums.length-1] = 1;
        for (int i = nums.length-1; i > 0; i--) {
            temp2[i-1] = nums[i]*temp2[i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = temp1[i] * temp2[i];
        }

        return result;
    }
    public int[] productExceptSelf2(int[] nums) {
        int result[] = new int[nums.length];
        int n = 1;
        int zero = 0; // count how many zero are in array
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && zero <= 0) {// if it's count of zero is one , it's okay
                zero++;
                continue;
            }
            n*= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(zero >= 1 && nums[i] != 0) result[i] = 0; //zero >=1 then everything is 0
            else if(nums[i] == 0) result[i] = n;    //zero == 0 and nums[i] = 0 / n
            else result[i] = n/nums[i]; // n/ num[i]
        }
        return result;
    }

    //solution in discussion
    public int[] productExceptSelf3(int[] nums) {
        //       1  2  3  4
        //temp 1 1  1  2  6
        //temp 2 24 12 4  1
        int result[] = new int[nums.length];
        result[0] = 1;
        for (int i = 0; i < nums.length-1; i++) {
            result[i+1] = nums[i] * result[i];
        }
        int r = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = result[i]*r;
            r*=nums[i];
        }
        return result;

    }

}
