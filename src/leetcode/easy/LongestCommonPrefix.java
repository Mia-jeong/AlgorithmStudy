package leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    //LPU
    //["flower","flow","flight"]
    // ["flower","flow"] > flow
    // "flow", "flight" > fl
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length ; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;

    }
    //vertical scan
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0 || strs ==null) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || temp != strs[j].charAt(j)){
                    return strs[0].substring(0, i);
                }
            }

        }
        return strs[0];

    }
    //divide and conquer
    public String longestCommonPrefix3(String[] strs) {
        if(strs.length == 0 || strs ==null) return "";
        return divideAndConquer(strs, 0, strs.length-1);
    }
    public String divideAndConquer(String[] strs, int start, int end){
        if(start == end) return strs[start];

        int mid = (start+end)/2;
        String left = divideAndConquer(strs, start, mid);
        String right = divideAndConquer(strs, mid+1, end);
        return compareString(left, right);
    }
    public String compareString(String left, String right){
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            if(left.charAt(i) != right.charAt(i)) return left.substring(0, i);
        }
        return left.substring(0, len);
    }
}
