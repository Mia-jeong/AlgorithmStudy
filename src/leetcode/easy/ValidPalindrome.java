package leetcode.easy;

public class ValidPalindrome {
    //I have no idea of that there's isLetterOrDigit method in Character!!
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            char sc = s.charAt(start);
            char ec = s.charAt(end);
            if(Character.isLetterOrDigit(sc) && Character.isLetterOrDigit(ec)){
                if(Character.toLowerCase(sc)!= Character.toLowerCase(ec)){
                    return false;
                }
                start++;
                end--;
            }else if(Character.isLetterOrDigit(sc)){
                end--;
            }else {
                start++;
            }
        }
        return true;
    }

    public boolean number(int num){
        return (num >= 65 && num <= 90) || (num >= 97 && num <= 122) || (num >= 48 && num >= 57);
    }
}
