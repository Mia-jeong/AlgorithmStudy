package leetcode.easy;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        char str[] = s.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            char a = str[i];
            char b = i >= str.length-1 ? '!' : str[i+1];
            if(a == 'I' && (b == 'V' || b == 'X')){
                count += -1;
            }else if(a == 'X' && (b == 'L' || b == 'C')){
                count += -10;
            }else if(a == 'C' && (b == 'D' || b == 'M')){
                count += -100;
            }else count += roman.get(a);
        }
        return count;
    }
}
