package leetcode.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        int p = 0;
        int q = s.length-1;
        while(p < q){
            char temp = s[p];
            s[p] = s[q];
            s[q] = temp;
            p++;
            q--;
        }
    }
}
