package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        list.add(new ArrayList<>()); // add []
        for (int i = 0; i < nums.length; i++) { // sublist size count 0~nums.length
            for (int j = 0; j < nums.length; j++) { //index loop
                recursion(nums, j, i, new ArrayList<>());
            }
        }

        return list;
    }
    /*
    * @param
    * @nums : array given by user
    * @idx: index of array to be added to subList
    * @count : subList size availablity
    * @subList : subList
    * */
    public void recursion(int[] nums, int idx, int count, List<Integer> subList){
        subList.add(nums[idx]);
        if(count == 0){
            list.add(subList);
        }else if((count != 0 && idx+1 ==nums.length)) {
            return;
        }else {
            for (int i = idx+1; i < nums.length; i++) {
                recursion(nums, i, count-1, new ArrayList<>(subList));
            }
        }
    }

    /*******solution in discussion************/
    public List<List<Integer>> subsets2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int current = nums[i];
            int size = finalList.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subList = new ArrayList<>();
                subList.addAll(finalList.get(j));
                subList.add(current);
                finalList.add(subList);
            }
        }

        return finalList;
    }
    /*
     nums = [1, 2, 3]
     finalList:  []         [],[1]             [],[1],[2],[1,2]
     current  :   1           2                        3
     size:        1           2                        4
     subList:    [1]          [2]                    [3]
                            [1, 2]                  [1, 3]
                                                    [2, 3]
                                                   [1, 2, ]
     */
}
