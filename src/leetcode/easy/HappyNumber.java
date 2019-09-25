package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HappyNumber {
    public boolean isHappy(int n) {
        int num = n;

        HashMap<Integer, Boolean> flag  = new HashMap<>();
        while(num != 1){
            int sum = 0;
            int temp = num;
            while(temp > 0){
                sum+= (temp%10) * (temp%10);
                temp/= 10;
            }
            num = sum;
            if(flag.get(sum) != null) return false;
            else{
                flag.put(sum, true);
            }
        }
        return true;
    }
    //solution 1 in discussion
    public boolean isHappy2(int n) {
        List<Integer> list = new ArrayList<Integer>();
        return Happy(list, n);
    }

    public boolean Happy(List<Integer> list, int n) {
        int sum = 0;
        list.add(n);
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        if (sum == 1)
            return true;
        else if (list.contains(sum))
            return false;
        else
            return Happy(list, sum);
    }
}
