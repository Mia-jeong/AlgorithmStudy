package leetcode.easy;

public class SumOfTwoIntegers {
    //솔직히 이거 잘 모르겠다 비트연산자 공부하자 ㅎ...

    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        return getSum(a^b, (a&b)<<1);
    }
}
