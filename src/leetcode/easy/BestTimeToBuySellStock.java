package leetcode.easy;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int diff = prices[j]-prices[i];
                if(diff > max) max = diff;
            }
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if(min > prices[i]) min = prices[i];
            else if(prices[i]-min > max) max = prices[i]-min;
        }

        return max;
    }
    //because we should find the lowest value and the highest value
    //if we find lowest value, save it to min,
    //and if the current value is higher than min, let's calculate the difference between 2 numbers
    //if it's bigger than max, save it to max
}
