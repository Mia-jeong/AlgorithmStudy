package leetcode.math.easy;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int low = 0;
        int high = n;
        int storage[] = new int[n+1];

        for (int i = 0; i < n; i++) {
            if(S.charAt(i) == 'I'){
                storage[i] = low++;
            }else {
                storage[i] = high--;
            }
        }
        storage[n] = low; //low are the same as the high.
        return storage;
    }
}
