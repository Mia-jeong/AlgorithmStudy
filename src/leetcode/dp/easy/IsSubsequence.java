package leetcode.dp.easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        if(s.length() == 0) return true;
        for (int i = 0; i < t.length(); i++) {
            char sc = s.charAt(sPointer);
            char tc = t.charAt(i);
            if(sc == tc) sPointer++;
            if(sPointer >= s.length()) return true;
        }
        return false;
    }

    public boolean bestSolution(String s, String t) {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }

        return true;
    }
}
