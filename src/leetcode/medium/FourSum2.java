package leetcode.medium;

import java.util.HashMap;

public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        int total = 0;
        for (int a : A){
            for (int b: B){
                int sum = a+b;
                storage.put(sum, storage.getOrDefault(sum, 0)+1);
            }
        }

        for (int c : C){
            for (int d: D){
                int sum = (c+d)*-1;
                total += storage.getOrDefault(sum, 0);
            }
        }

        return total;
    }
}
