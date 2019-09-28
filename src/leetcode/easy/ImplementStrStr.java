package leetcode.easy;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if((haystack.length()-i) < needle.length()) break;
            if(haystack.charAt(i) != needle.charAt(0)) continue;
            boolean f =true;
            for (int j = 1; j < needle.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(j+i)){
                    f = false; break;
                }
            }
            if(f){
                result = i;
                break;
            }
        }
        return result;
    }
    //solution in discussion
    public int strStr2(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int nLength = needle.length();
        for (int i = 0; i < haystack.length() - nLength + 1; i ++) {
            String possNeedle = haystack.substring(i, i + nLength);
            if (possNeedle.equals(needle)) return i;
        }
        return -1;
    }
}
