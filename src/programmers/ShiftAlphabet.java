package programmers;

public class ShiftAlphabet {
    public String solution(String s, int n) {
        String answer = "";
        n %= 26;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(Character.isLowerCase(a)){
                a = (char)((a-'a'+n)%26+'a');
            }else if(Character.isUpperCase(a))a = (char)((a-'A'+n)%26+'A');
            answer += a;
        }
        return answer;
    }
}
