package leetcode.math.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Mock Object for Problem
class CustomFunction {
    int f(int x, int y){
        return 0;
    }
}

public class FindPositiveIntegerSolutionForAGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new LinkedList<>();

        for (int x = 1; x <= 1000; x++) { // upper limit is 1000
            int low = 1, high = 1001;
            while (low < high) {
                int mid = (low + high) / 2;
                if (customfunction.f(x, mid) < z) {
                    low = mid + 1;
                } else if(customfunction.f(x, mid) > z) {
                    high = mid;
                }else{
                    res.add(Arrays.asList(x, mid));
                    break;
                }
            }

        }
        return res;
    }
}
