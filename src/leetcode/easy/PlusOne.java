package leetcode.easy;

import java.util.Stack;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0 || digits == null) return new int[]{1};
        int lastDigits = digits[digits.length-1];
        if( lastDigits < 9) {
            digits[digits.length-1] += 1;
            return digits;
        }else {
            digits[digits.length-1] = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = digits.length-2; i >= 0 ; i--) {
                int temp = digits[i];
                if(temp < 9){
                    digits[i] += 1;
                    return digits;
                }else {
                    digits[i] = 0;
                    stack.push(0);
                }
            }
            stack.push(1);
            int arr[] = new int[stack.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = stack.pop();
            }
            return arr;
        }
    }
    //solution1 in discussion
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            if(digits[i] == 9) digits[i] = 0;
            else {
                digits[i] += 1;
                break;
            }
        }
        if(digits[0] == 0) {
            int result[] = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
