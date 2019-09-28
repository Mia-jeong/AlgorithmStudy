package leetcode.easy;

public class FactorialTrailingZeroes {

    //in order to have 0 in the tail
    // we should multiple 10 * number
    // and 10 = 2 * 5;
    // it turns out time limit
    public int trailingZeroes(int n) {
        int five = 0;
        int two  = 0;
        for (int i = n; i >= 2  ; i--) {
            while(i % 5 == 0){
                i /= 5;
                five++;
            }
            while(i % 2 == 0){
                i /= 2;
                two++;
            }
        }
        return Math.min(five, two);
    }

    //solution in discussion
    //https://www.purplemath.com/modules/factzero.htm
    // 1000
    // 1000/ 5 = 200
    // 1000 / 25(=5*5) = 4
    // 1000/ 125(=5*5*5) = 8
    // 1000/ 625(=5*5*5*5) = 1
    // so we don't need to worry about duplicate counts.
    // for example 25 need 2 five. but 1000 / 5 only counts 25 as 1
    public int trailingZeroes2(int n) {
        int count = 0;

        while(n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

}
