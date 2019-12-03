package leetcode.dp.easy;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int storage[] = new int[cost.length];
        storage[0] = cost[0];
        storage[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            storage[i] = Math.min(storage[i-1], storage[i-2])+cost[i];
        }
        int len = storage.length;

        return Math.min(storage[len-1], storage[len-2]);
    }
    /*
    *a   1 100 1  1  1  100  1  1  100  1
    *b   1 100 2  3  3  103  4  5  104  6
    *
    *b[index] = min(b[index-1], b[index-2])+a[index]
    *user can only climb either one or step at once
    *
    * */
}
