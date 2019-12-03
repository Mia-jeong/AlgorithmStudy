package leetcode.dp.easy;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length > 0){
            int storage[] = new int[prices.length];
            storage[0] = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if(prices[i] < storage[i-1]){
                    storage[i] = prices[i];
                }else {
                    storage[i] = storage[i-1];
                    int value = prices[i] - storage[i];
                    if(max < value) max = value;
                }
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
