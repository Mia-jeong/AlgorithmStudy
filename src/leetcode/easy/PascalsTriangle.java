package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = null;
        for (int i = 1; i <= numRows ; i++) {
            temp = makeList(i, temp);
            result.add(temp);
        }
        return result;

    }
    public List<Integer> makeList(int i, List<Integer> list){

        List<Integer> result = new ArrayList<>();
        result.add(1);
        if(list == null) return result;
        for (int j = 1; j < list.size(); j++) {
            result.add(list.get(j-1)+list.get(j));
        }
        if(i > 1) result.add(1);
        return result;
    }
}
