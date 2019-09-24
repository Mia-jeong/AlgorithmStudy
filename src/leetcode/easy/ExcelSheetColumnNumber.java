package leetcode.easy;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        final int num = 64;
        final int standard = 26;
        if(s.length() == 0) return 0;
        if(s.length() == 1) return ( (int) s.charAt(0) ) - num;
        char[] str = s.toCharArray();
        int len = str.length-1;
        int sum = 0;
        for (int i = 0; i < str.length; i++, len--) {
            int c = (int) str[i];
            double temp = 0;
            int val = (c) - num;
            if(len>0) temp += Math.pow(standard, len) * val;
            else temp += val;
            sum += temp;
            System.out.println(sum);
        }
        return sum;

    }
    //the best solution I think in discussion
    public int titleToNumber2(String s) {
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = (int) ((s.charAt(i) - 'A') + 1);
            col = (col * 26) + current;
        }
        return col;
    }

}
