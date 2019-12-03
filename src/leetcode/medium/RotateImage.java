package leetcode.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length / 2;
        int len = matrix.length-1;
        int temp = matrix[0][len];
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < len-(i*2); j++) {
                temp = matrix[i][len-i];
                matrix[i][len-i] = matrix[i][j];
                int t = temp;


            }
        }
    }

}
