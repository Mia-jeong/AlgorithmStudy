package leetcode.easy;

public class ReverseInteger {
    // 422
    // 2 * 10^2 + 2 * 10^1 + 4 *10^0
    //(((2 * 10) + 2)*10)+4
    public int reverse(int x) {
        long temp = 0;
        while(x != 0){
            temp = (temp * 10) + (x % 10);
            x /= 10;
        }
        if (temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE) return 0;

        return (int)temp;

    }
}
