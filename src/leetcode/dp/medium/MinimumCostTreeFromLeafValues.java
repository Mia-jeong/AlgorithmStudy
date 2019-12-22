package leetcode.dp.medium;

public class MinimumCostTreeFromLeafValues {

    public static int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            int right = i+1;
            for (int left = 0; left<len && right <len; left++) {
                if(right - left == 1){
                    dp[left][right] = arr[left]*arr[right];
                }else {
                    for(int index = left; index < right; index++) {
                        System.out.println("left " + left + " right " + right + " index" + index);
                        if(dp[left][right] == 0) {
                            System.out.println("dp == 0");
                            dp[left][right] = dp[left][index] + dp[index + 1][right] + maxValue(arr, left, index) * maxValue(arr, index + 1, right);
                            detailPrint(left, right, index);
                        } else {
                            System.out.println("dp  > 0");
                            dp[left][right] = Math.min(dp[left][right], dp[left][index] + dp[index + 1][right] + maxValue(arr, left, index) * maxValue(arr, index + 1, right));
                            detailPrint(left, right, index);
                        }
                    }
                }
                right++;
            }
            print(dp);
        }
        return dp[0][len-1];

    }

    public static int mctFromLeafValues2(int[] arr) {
        int len = arr.length;
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            int right = i+1;
            for (int left = 0; left<len && right <len; left++) {
                if(right - left == 1){
                    dp[left][right] = arr[left]*arr[right];
                }else {
                    for(int index = left; index < right; index++) {
                        if(dp[left][right] == 0) {
                            dp[left][right] = dp[left][index] + dp[index + 1][right] + maxValue(arr, left, index) * maxValue(arr, index + 1, right);
                        } else {
                            dp[left][right] = Math.min(dp[left][right], dp[left][index] + dp[index + 1][right] + maxValue(arr, left, index) * maxValue(arr, index + 1, right));
                        }
                    }
                }
                right++;
            }
            print(dp);
        }
        return dp[0][len-1];

    }
    public static void detailPrint(int left, int right, int index){
        System.out.println("dp["+left+"]["+right+"] = "+ "dp["+left+"]["+index+"] + "+
                "dp["+(index+1)+"]["+right+"] "+ "maxValue["+left+"]["+index+"] * "+"maxValue["+(index+1)+"]["+right+"]");
        System.out.println();
    }

    public static void print(int dp[][]){
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int maxValue(int[] arr, int start, int end){
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if(arr[i] > max) max = arr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,7,2,12,15,10,3,9};
        //solution(arr);
        System.out.println("============");
        mctFromLeafValues(arr);
    }
}
