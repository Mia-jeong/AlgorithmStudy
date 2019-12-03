package leetcode.dp.easy;

public class DivisorGame {
    public static boolean divisorGame(int N) {
        int range = N+1>4? N+1:4;
        boolean storage[] = new boolean[range];
        //1, 3 is already set to false as a default
        storage[2] = true;

        for (int i = 4; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if(i%j == 0){
                    boolean temp = storage[i-j];
                    if(!temp) {
                        storage[i] = true;
                        break;
                    }
                }
            }
        }
        return storage[N];

    }

    public static boolean bestSolution(int N) {
        return N % 2 == 0;

    }

    public static void main(String[] args) {
        int N = 8;
        divisorGame(N);
    }
}
