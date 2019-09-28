package programmers;

import java.util.HashMap;

//완주하지 못한 선수
public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            Integer a = map.get(completion[i]);
            if(a != null) map.put(completion[i], a+1);
            else map.put(completion[i], 1);
        }

        for (int i = 0; i < participant.length; i++) {
            Integer a = map.get(participant[i]);
            if(a == null){
                answer = participant[i];
                break;
            }else {
                if(a <= 1) map.remove(participant[i]);
                else map.put(participant[i], a-1);
            }
        }
        return answer;
    }
}
