package leetcode.easy;

public class BestTimeToBuySellStock2 {

    //I should write Graph!
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1])
                max += prices[i]-prices[i-1];
        }
        return max;
    }

    public int maxProfixBruteForce(int[] prices){
        return recursive(prices, 0);
    }

    public int recursive(int prices[], int index){
        if(index >= prices.length) return 0;
        int maxValue = 0;
        for (int i = index; i < prices.length; i++) {
            int maxProfit = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] > prices[i]){
                    int temp = (prices[j]-prices[i]) + recursive(prices, j+1);
                    if(temp > maxProfit) maxProfit= temp;
                }
            }
            if(maxProfit > maxValue) maxValue = maxProfit;
        }
        return maxValue;
    }
}
