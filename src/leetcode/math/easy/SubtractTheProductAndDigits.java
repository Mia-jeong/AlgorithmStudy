package leetcode.math.easy;

public class SubtractTheProductAndDigits {

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int temp = n;
        while(temp > 0){
            int a = temp % 10;
            product *= a;
            sum += a;
            temp /= 10;
        }

        return product-sum;
    }
}
