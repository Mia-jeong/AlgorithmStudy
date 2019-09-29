package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    List<List<Integer>> result = new LinkedList<>();
    int[] each;
    boolean flag[];
    public List<List<Integer>> permute(int[] nums) {
        each = new int[nums.length];
        result = new LinkedList<>();
        flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = true;
            recursive(nums, i, 0);
            flag[i] = false;
        }
        return result;
    }

    public void recursive(int nums[], int idx, int eachIdx){
        if(eachIdx == nums.length-1){
            each[eachIdx] = nums[idx];
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < each.length; i++) list.add(each[i]);
            result.add(list);
            return;
        }
        else {
            each[eachIdx] = nums[idx];
            eachIdx += 1;
            for (int i = 0; i < nums.length; i++) {
                if(!flag[i]){
                    flag[i]= true;
                    recursive(nums, i, eachIdx);
                    flag[i]= false;
                }
            }
        }
    }

    //solution in discussion
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] isUsed) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!isUsed[i]) {
                temp.add(nums[i]);
                isUsed[i] = true;
                dfs(res, nums, temp, isUsed);
                temp.remove(temp.size() - 1); //* remove!!
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permute(new int[]{1, 2, 3});
    }
}
