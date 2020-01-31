package leetcode.dp.medium;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if(len < 2) return 0;
        int dp[] = new int[len];

        for (int i = 1; i < len; i++) {
            int current = prices[i];
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                int compareTo = prices[j];
                int difference = current -compareTo - fee;
                int prevMax = dp[Math.max(j-1, 0)];
                if(tempMax < prevMax+difference){
                    tempMax = prevMax+difference;
                }

                System.out.printf("current: %d, compareTo: %d, difference: %d, prevMax: %d, tempMax: %d "
                        , current, compareTo, difference, prevMax, tempMax);
                System.out.println();
            }
            dp[i] = Math.max(tempMax, dp[i-1]);
            System.out.printf("dp[%d] : %d", i, dp[i]);
            System.out.println();
        }

        return dp[len-1];
    }

}
