package leetcode.dp.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestStringChain {

    public static int longestStrChain(String[] words) {

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        HashMap<String, Integer> dp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(String word : words) {
            if(dp.containsKey(word))continue;
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String deletedString = sb.toString();
                if(dp.containsKey(deletedString)){
                    dp.put(word, Math.max(dp.get(word), dp.get(deletedString)+1));
                }

            }
            if(max < dp.get(word)){
                max = dp.get(word);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        longestStrChain(words);
    }

}
