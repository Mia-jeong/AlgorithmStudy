package leetcode.dp.medium;

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = s.charAt(i)+"";
        }
        int count = len;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                int d = i+j;
                String a = dp[j][d-1];
                String b = dp[j+1][d];
                String reverseB = ( new StringBuffer(b) ).reverse().toString();
                //System.out.println(" [a] " + a + "[ b] " +dp[j+1][d]);
                if( a.equals(reverseB)){
                    count++;
                    System.out.println(" [a] " + a + "[ b] " +dp[j+1][d]);
                }
                dp[j][d] = a.charAt(0)+b;
            }
        }
        return count;
    }

    public static int countSubstrings2(String s) {
        int len = s.length();
        Boolean[][] dp = new Boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int count = len;
        for (int d = 1; d < len; d++) {
            for (int i = 0; i < len-d; i++) {
                int j = d+i;
                boolean flag = s.charAt(i) == s.charAt(j);
                if(j-i < 3) {
                    dp[i][j] = flag;
                }else if(flag){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j] ) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "sdfxcvzasfdaadf";
        int count = countSubstrings2(s);
        System.out.println(count);
    }
}
