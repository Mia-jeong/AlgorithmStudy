package leetcode.easy;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        while(n != 0 ){
            int mod = n % 3;
            n /= 3;
            if(n == 0 && mod == 0) return true;
        }
        return false;
    }

    //solution 1 in discussion
    public boolean isPowerOfThree2(int n) {
        if(n <= 0) return false;
        while(n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
    //solution2
}
