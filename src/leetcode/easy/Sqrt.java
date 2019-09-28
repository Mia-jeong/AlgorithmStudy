package leetcode.easy;

public class Sqrt {

    // mid * mid could be overflow. so it's better using x/mid == mid
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int s = 1;
        int e = x;
        int mid = 0, sqrt = x;
        while(s <= e){
            mid = s+(e-s) / 2;
            sqrt = x / mid;

            if ( mid > sqrt ) e = mid-1;
            else {
                s = mid+1;
                if(s > x/s) return mid;
            }

        }
        return s;
    }
}
