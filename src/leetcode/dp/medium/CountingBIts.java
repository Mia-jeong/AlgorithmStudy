package leetcode.dp.medium;

public class CountingBIts {

    public static int[] countBits(int num) {
        int storage[] = new int[num+1];

        if(num == 0) return storage;

        if(num == 1) storage[1] = 1;
        else {
            storage[1] = 1;
            storage[2] = 1;

            for (int i = 3; i <= num; i++) {
                int n = 2;
                while(true){
                    if(n*2 > i){
                        break;
                    }else {
                        n*=2;
                    }
                }
                storage[i] = 1 + storage[i-n];

            }
        }
        return storage;
    }

    public int[] bestSolution1(int num) {
        int[] storage = new int[num + 1];
        for(int i = 1; i <= num; i++){
            storage[i] = storage[i/2];
            if(i%2 == 1) storage[i]++;
        }
        return storage;
    }

    public int[] bestSolution2(int num) {
        int result[] = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index){
            if (offset * 2 == index){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }
    /*
    *   dp[0] = 0;

        dp[1] = dp[0] + 1;

        dp[2] = dp[0] + 1;

        dp[3] = dp[1] +1;

        dp[4] = dp[0] + 1;

        dp[5] = dp[1] + 1;

        dp[6] = dp[2] + 1;

        dp[7] = dp[3] + 1;

        dp[8] = dp[0] + 1;
*
        dp[1] = dp[1-1] + 1;

        dp[2] = dp[2-2] + 1;

        dp[3] = dp[3-2] +1;

        dp[4] = dp[4-4] + 1;

        dp[5] = dp[5-4] + 1;

        dp[6] = dp[6-4] + 1;

        dp[7] = dp[7-4] + 1;

        dp[8] = dp[8-8] + 1;
..
    * */
}
