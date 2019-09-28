package leetcode.easy;

public class NumberOf1Bits {
    //mask = 1, 2, 4 ,8 ,15 ...
    // 1&1 = 1 / 1&0 = 0
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((n&mask) != 0) count++;
            mask = mask << 1;
        }
        return count;
    }
    /*
      13 = 00001101, 12 = 00001100 > 00001100
      12 = 00001100, 11 = 00001011 > 00001000
       8 = 00001000,  7 = 00000111 > 00000000

       count = 3
     */
    public int hammingWeight2(int n) {
        int sum = 0;
        while( n != 0){
            sum++;
            n &= (n-1);
        }
        return sum;
    }
}
