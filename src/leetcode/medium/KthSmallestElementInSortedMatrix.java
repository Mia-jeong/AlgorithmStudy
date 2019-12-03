package leetcode.medium;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length-1;
        int start = matrix[0][0];
        int end = matrix[len][len]+1;
        while (start < end){
            int count = 0;
            int mid = start + (end - start)/2;
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j <= len ; j++) {
                    if(matrix[i][j] <=mid){
                        count++;
                    }else break;
                }
            }
            if(count < k) start = mid+1;
            else end = mid;

        }
        return start;
    }
}
