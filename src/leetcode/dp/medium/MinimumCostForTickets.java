package leetcode.dp.medium;

public class MinimumCostForTickets {

    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        boolean isIncluded[]  = new boolean[lastDay+1];
        for (int day: days) {
            isIncluded[day] = true;
        }
        int minCosts[] = new int[lastDay+1];

        for (int i = 1; i < minCosts.length; i++) {
            if(!isIncluded[i]){
                minCosts[i] = minCosts[i-1];
                continue;
            }

            int one = minCosts[i-1]+costs[0]; //day 1
            int seven = minCosts[Math.max(0, i-7)]+costs[1];
            int thirty = minCosts[Math.max(0, i-30)]+costs[2];
            minCosts[i] = Math.min(one, Math.min(seven, thirty));
        }
        return minCosts[lastDay];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        int count = mincostTickets(days, costs);
    }
}
