package programmers;

import java.util.ArrayList;
import java.util.List;

//같은 숫자는 싫어
public class NoSameNumber {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        if(arr.length > 0) {
            int temp = arr[0];
            list.add(temp);
            for (int i = 1, j=1; i < arr.length; i++) {
                if(list.get(j-1) != arr[i]) {
                    list.add(arr[i]);
                    j++;
                }
            }
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }
}
