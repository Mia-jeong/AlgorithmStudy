package leetcode.easy;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int storage[] = new int[n+1];
        return recursive(n, storage);
    }
    public int recursive(int n, int[] storage){
        if(n < 0)return 0;
        if(n == 0)return 1;
        if(storage[n] != 0) return storage[n];
        int a = recursive(n-1, storage);
        int b = recursive(n-2, storage);
        storage[n] = a+b;
        return storage[n];
    }

    /*
     for example, counts to 4 equals counts to 3 plus counts to 2

       4 - 1 (3)- 1 - 1 - 1
                    - 2
                - 2 - 1
         - 2 (2)- 1 - 1
                - 2
    */
    public int climbStairsByDP(int n){
        if(n == 1) return 1;
        int storage[] = new int[n+1];
        storage[1] =1;
        storage[2] =2;
        for (int i = 3; i < storage.length; i++) {
            storage[i] = storage[i-2] + storage[i-1];
        }
        return storage[n];
    }

}
