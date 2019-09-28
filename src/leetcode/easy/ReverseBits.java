package leetcode.easy;

import java.math.BigInteger;
import java.util.Arrays;

public class ReverseBits {
    public int reverseBits(int n) {
        String bitStr = Integer.toBinaryString(n);
        System.out.println(bitStr);
        while(bitStr.length() <= 32) bitStr = "0"+bitStr;
        char[] array = bitStr.toCharArray();
        int start = 1, end = bitStr.length()-1;
        while(start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        bitStr = new String(array);
        long result = Long.parseLong(bitStr, 2);
        return (int)result;
    }

    //solution in discussion
    //first you can get the right most digit of binary n )ex) 10100101000001111010011(1)
    // > n & 1
    //second you can shift the right most digit to left up to 32 -i ex)reverseLsb =100000000000000000000000000000
    // > result | reverseLsb
    //finally you cna go to next digit ex)10100101000001111010011
    // > n = n>>>1
    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i ++) {
            int lsb = n & 1; // returns right most digit of binary n
            //String bitStr = Integer.toBinaryString(lsb);
            //System.out.println("lsb " + bitStr);
            int reverseLsb = lsb << (31 - i); // shifts lsb to opposite side
            //String bitStr2 = Integer.toBinaryString(reverseLsb);
            //System.out.println("reverseLsb " + bitStr2);
            result = result | reverseLsb; // add up numbers lsb by lsb
            //String bitStr3 = Integer.toBinaryString(result);
            //System.out.println("result " + bitStr3);
            n = n >>> 1; // go to next lsb
            //String bitStr4= Integer.toBinaryString(n);
            //System.out.println("n " + bitStr4);
        }
        return result;
    }

    /*
        lsb 0
        reverseLsb 0
        result 0
        n 1010010100000111101001110
        lsb 0
        reverseLsb 0
        result 0
        n 101001010000011110100111
        lsb 1
        reverseLsb 100000000000000000000000000000
        result 100000000000000000000000000000
        n 10100101000001111010011
        lsb 1
        reverseLsb 10000000000000000000000000000
        result 110000000000000000000000000000
        n 1010010100000111101001
        lsb 1
        reverseLsb 1000000000000000000000000000
        result 111000000000000000000000000000
        n 101001010000011110100
        lsb 0
        reverseLsb 0
        result 111000000000000000000000000000
        n 10100101000001111010
        lsb 0
        reverseLsb 0
        result 111000000000000000000000000000
        n 1010010100000111101
        lsb 1
        reverseLsb 1000000000000000000000000
        result 111001000000000000000000000000
        n 101001010000011110
        lsb 0
        reverseLsb 0
        result 111001000000000000000000000000
        n 10100101000001111
        lsb 1
        reverseLsb 10000000000000000000000
        result 111001010000000000000000000000
        n 1010010100000111
        lsb 1
        reverseLsb 1000000000000000000000
        result 111001011000000000000000000000
        n 101001010000011
        lsb 1
        reverseLsb 100000000000000000000
        result 111001011100000000000000000000
        n 10100101000001
        lsb 1
        reverseLsb 10000000000000000000
        result 111001011110000000000000000000
        n 1010010100000
        lsb 0
        reverseLsb 0
        result 111001011110000000000000000000
        n 101001010000
        lsb 0
        reverseLsb 0
        result 111001011110000000000000000000
        n 10100101000
        lsb 0
        reverseLsb 0
        result 111001011110000000000000000000
        n 1010010100
        lsb 0
        reverseLsb 0
        result 111001011110000000000000000000
        n 101001010
        lsb 0
        reverseLsb 0
        result 111001011110000000000000000000
        n 10100101
        lsb 1
        reverseLsb 10000000000000
        result 111001011110000010000000000000
        n 1010010
        lsb 0
        reverseLsb 0
        result 111001011110000010000000000000
        n 101001
        lsb 1
        reverseLsb 100000000000
        result 111001011110000010100000000000
        n 10100
        lsb 0
        reverseLsb 0
        result 111001011110000010100000000000
        n 1010
        lsb 0
        reverseLsb 0
        result 111001011110000010100000000000
        n 101
        lsb 1
        reverseLsb 100000000
        result 111001011110000010100100000000
        n 10
        lsb 0
        reverseLsb 0
        result 111001011110000010100100000000
        n 1
    * */
}
