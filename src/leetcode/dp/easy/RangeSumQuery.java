package leetcode.dp.easy;

public class RangeSumQuery {

    //303. https://leetcode.com/problems/range-sum-query-immutable/

    int sum[];
    public RangeSumQuery(int[] nums) {
        sum = new int[nums.length];
        if(sum.length > 0) {
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i-1]+nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i > 0){
            return sum[j] - sum[i-1];
        }else {
            return sum[j];
        }
    }
    /*
    *num   -2  0  3  -5  2  -1
    *sum   -2 -2  1  -4  -2  -3
    *
    * sumRange(i, j) = sum[j] -sum[i-1]
    * sumRange(1, 4) = -2 -(-2) = 0
    *
    * */
}
