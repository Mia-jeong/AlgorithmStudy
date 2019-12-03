package leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            System.out.println("key " + key);
            if(map.get(key) == null) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
