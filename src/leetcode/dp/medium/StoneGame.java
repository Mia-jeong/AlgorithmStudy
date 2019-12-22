package leetcode.dp.medium;

public class StoneGame {

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
                detailPrint(i, d, dp, piles);
            }
            print(dp);

        }

        return dp[0][n - 1] > 0;
    }

    public static void print(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void detailPrint(int i, int d, int[][] dp, int[] piles){
        System.out.println("dp[" + i + "][" + (i + d) + "]= " + " ( p[" + i + "] - dp[" + (i + 1) + "][" + (i + d) + "] ) , (" +
                " ( p[" + (i + d) + "] - dp[" + (i) + "][" + (i + d - 1) + "] )");
    }

    public static void main(String[] args) {
        int n[] = {5, 3, 4, 5};
        stoneGame(n);

    }
}
