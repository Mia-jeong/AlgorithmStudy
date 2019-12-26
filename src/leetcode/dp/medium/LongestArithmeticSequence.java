package leetcode.dp.medium;

import java.util.HashMap;

public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {

        HashMap<Integer, Integer> dp[] = new HashMap[A.length];

        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            int current = A[i];
            for (int j = 0; j < i; j++) {
                int compareTo = A[j];
                int difference = current - compareTo;
                int prevValue = dp[j].getOrDefault(difference, 1);
                dp[i].put(difference, prevValue+1);
                if(prevValue+1 > max) max = prevValue+1;
            }
        }
        return max;
    }
}
