package leetcode.dp.medium;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public static int minFallingPathSumDP(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int start = j-1 < 0? 0 : j-1;
                int end = j + 1 >= m ? j : j+1;
                int min = Integer.MAX_VALUE;
                for (int z = start; z <= end; z++) {
                    if(dp[i-1][z] < min) min = dp[i-1][z];
                }
                dp[i][j] = A[i][j] + min;
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }


    public static void main(String[] args) {
        int[][] data = {{-51,-35,74},{-62,14,-53},{94,61,-10}};

        int sum = minFallingPathSumDP(data);
        System.out.println(sum);
    }
}
